package proyectoPAE;

import java.awt.im.InputContext;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Principal2 extends Application {

	private ResourceBundle rb;
	@Override
	public void start(Stage stage) throws Exception {
		Platform.setImplicitExit(true);
		stage.setOnCloseRequest((ae) -> {
			Platform.exit();
			System.exit(0);
		});
		
		System.getProperty("user.language");
		String resourceLocation = "resources.i18n.messages";
		InputContext context = InputContext.getInstance();  
		Locale locale = context.getLocale();
		rb = ResourceBundle.getBundle(resourceLocation, locale);

		GridPane grid = new GridPane();
		grid.setHgap(20);
		grid.setPrefSize(600, 500);
		grid.setVgap(15);
		grid.setPadding(new Insets(15));
	
		Scene scene = new Scene(grid);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//Botón para crear herramienta
		Button bt1 = new Button(rb.getString("main_createBtn"));
		//Botón para añadir materia
		Button bt2 = new Button(rb.getString("main_addBtn"));
		//Boton para settings
		Button bt3 = new Button("?");
		//Botón para ver materias
		Button bt4 = new Button(rb.getString("main_viewBtn"));
		//Botón para ver herramientas
		Button bt5 = new Button(rb.getString("main_viewBtn"));
	
		Label lb1 = new Label("Study Buddy");
		Label lb2 = new Label(rb.getString("main_subjectLb"));
		Label lb3 = new Label(rb.getString("main_toolLb"));
		ChoiceBox<String> cb = new ChoiceBox<>();
		ListView<String> lv1 = new ListView<String>();
		ListView<String> lv2 = new ListView<String>();
		lv1.setPrefWidth(270);
		lv2.setPrefWidth(270);

		cb.getItems().addAll(rb.getString("main_flashCardCb"), rb.getString("main_chartCb"));
		cb.getSelectionModel().selectFirst();
		cb.setPrefWidth(160);

		ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
		exec.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				Platform.runLater(() -> {
					ArrayList<OurImage> images = getImages();
					images.removeIf((i ->  !(i.getSubject().equals(lv1.getSelectionModel().getSelectedItem()))));
					ArrayList<FlashCard> flashcards = getFlashCards();
					flashcards.removeIf((fc ->  !(fc.getSubject().equals(lv1.getSelectionModel().getSelectedItem()))));
					ObservableList<String> listSubjects = FXCollections.observableArrayList(getSubjectNames());
					ObservableList<String> listFlashCards = FXCollections.observableArrayList(getFlashCardTitles(flashcards));
					ObservableList<String> listImages = FXCollections.observableArrayList(getImageTitles(images));
					
					lv1.setItems(listSubjects);
					if ((cb.getSelectionModel().getSelectedItem().startsWith(rb.getString("main_flashCardCb")))) {
						lv2.setItems(listFlashCards);
					} else {
						lv2.setItems(listImages);
					}
				});

			}
		}, 0, 300, TimeUnit.MILLISECONDS);

		lb1.setStyle("-fx-font-size: 30px");
		lb2.setStyle("-fx-font-size: 20px");
		lb3.setStyle("-fx-font-size: 15px");
		bt1.setPrefWidth(130);
		bt4.setPrefWidth(130);
		bt2.setPrefWidth(130);
		bt5.setPrefWidth(130);
		bt3.setPrefWidth(30);

		grid.add(lb1, 0, 0, 4, 1);
		grid.add(lb2, 0, 1, 2, 1);
		grid.add(lb3, 2, 1, 1, 1);
		grid.add(bt1, 2, 3, 1, 1);
		grid.add(cb, 3, 1, 1, 1);
		grid.add(bt4, 3, 3, 1, 1);
		grid.add(lv1, 0, 2, 2, 1);
		grid.add(lv2, 2, 2, 2, 1);
		grid.add(bt3, 0, 0, 1, 1);
		grid.add(bt2, 0, 3, 1, 1);
		grid.add(bt5, 1, 3, 1, 1);

		GridPane.setHalignment(lb1, HPos.CENTER);
		GridPane.setHalignment(bt1, HPos.CENTER);
		GridPane.setHalignment(lb2, HPos.CENTER);
		GridPane.setHalignment(lb3, HPos.CENTER);
		GridPane.setHalignment(cb, HPos.RIGHT);
		GridPane.setHalignment(bt3, HPos.LEFT);
		GridPane.setHalignment(bt2, HPos.CENTER);
		GridPane.setHalignment(bt4, HPos.CENTER);
		GridPane.setHalignment(bt5, HPos.CENTER);
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Study Buddy");
		stage.setResizable(false);

		//Acción del boton abrir ventana de newFlashcard o newImage
		bt1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (cb.getSelectionModel().getSelectedItem().startsWith(rb.getString("main_flashCardCb"))) {
					NewFlashCard2 create = new NewFlashCard2();
					Stage stage2 = new Stage();
					try {
						create.start(stage2);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					NewImage create = new NewImage();
					Stage stage2 = new Stage();
					try {
						create.start(stage2);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		//Acción del botón para abrir ventana de materia nueva
		bt2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				NewSubject2 sub = new NewSubject2();
				Stage stage = new Stage();
				try {
					sub.start(stage);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		//Acción del botón para abrir la ventana de settings
		bt3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Settings2 sett = new Settings2();
				Stage stage3 = new Stage();
				try {
					sett.start(stage3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//Acción del botón para ver materia
		bt4.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				if (cb.getSelectionModel().getSelectedItem().startsWith(rb.getString("main_flashCardCb"))) {
					ArrayList<FlashCard> flashCards = getFlashCards();
					FlashCard flashCard = null;
					for(FlashCard fc : flashCards){
						if(fc.getTitle().equals(lv2.getSelectionModel().getSelectedItem())){
							flashCard = fc;
							break;
						}
					}
					FlashCardView fcv = new FlashCardView(flashCard);
					Stage stage4 = new Stage();
					try {
						fcv.start(stage4);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else{
					ArrayList<OurImage> images = getImages();
					OurImage image = null;
					for(OurImage i : images){
						if(i.getTitle().equals(lv2.getSelectionModel().getSelectedItem())){
							image = i;
							break;
						}
					}
					OurImageView iv = new OurImageView(image);
					Stage stage5 = new Stage();
					try {
						iv.start(stage5);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}

			}	
		});
		//Acción del botón para ver herramienta
		bt5.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				ArrayList<Subject> subjects = getSubjects();
				Subject subject = null;
				for(Subject s : subjects){
					if(s.getName().equals(lv1.getSelectionModel().getSelectedItem())){
						subject = s;
						break;
					}
				}
				SubjectView sv = new SubjectView(subject);
				Stage stage6 = new Stage();
				try {
					sv.start(stage6);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static ArrayList<Subject> getSubjects() {
		SubjectManager sb = new SubjectManager();
		return sb.getSubjects();
	}

	public static ArrayList<OurImage> getImages() {
		ImageManager im = new ImageManager();
		return im.getImages();
	}

	public static ArrayList<FlashCard> getFlashCards() {
		FlashCardManager fcm = new FlashCardManager();
		return fcm.getFlashCards();
	}

	public static ArrayList<String> getSubjectNames() {
		SubjectManager sb = new SubjectManager();
		return sb.getSubjectNames();
	}

	public static ArrayList<String> getFlashCardTitles(ArrayList<FlashCard> flashcards) {
		ArrayList<String> names = new ArrayList<String>();
        for(FlashCard fc : flashcards){
        	names.add(fc.getTitle());
        }
        return names;
	}

	public static ArrayList<String> getImageTitles(ArrayList<OurImage> images) {
        ArrayList<String> names = new ArrayList<String>();
        for(OurImage i : images){
        	names.add(i.getTitle());
        }
        return names;
	}

	public static void main(String[] args) {
		launch(args);
	}

}