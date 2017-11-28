package proyectoPAE;

import java.awt.im.InputContext;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class NewImage extends Application {
	private ResourceBundle rb;
	String url;
	@Override
	public void start(Stage stage) throws Exception {
		//
		System.getProperty("user.language");
		String resourceLocation = "resources.i18n.messages";
		InputContext context = InputContext.getInstance();  
		Locale locale = context.getLocale();
		rb = ResourceBundle.getBundle(resourceLocation, locale);
		//Se crea el grid
		GridPane grid = new GridPane();
		grid.setHgap(15);
		grid.setPrefSize(475, 300);
		grid.setVgap(12);
		grid.setPadding(new Insets(12));
		Scene scene = new Scene(grid);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//Botón para crear
		Button bt1 = new Button(rb.getString("main_createBtn"));
		Label lb1 = new Label(rb.getString("main_newImageLb"));
		lb1.setStyle("-fx-font-size: 24px");
		//Label del titulo
		Label lb2 = new Label(rb.getString("main_titleLb"));
		//Label de  descripcion
		Label lb3 = new Label(rb.getString("main_descriptionLb"));
		//Botón de browse
		Button chooseFile = new Button(rb.getString("main_browse"));
		Label lbPath = new Label();
		TextField tf = new TextField();
		TextArea ta = new TextArea();
		ChoiceBox<String> choice = new ChoiceBox<String>();
		choice.setPrefWidth(320);
		ObservableList<String> listSubjects = FXCollections.observableArrayList(getSubjectNames());
		choice.getItems().addAll(listSubjects);
		choice.getSelectionModel().selectFirst();
		ta.setPrefSize(320, 50);
		ta.setWrapText(true);
		
		grid.add(lb1, 0, 0, 2, 1);
		grid.add(lb2, 0, 1, 1, 1);
		grid.add(tf, 1, 1, 1, 1);
		grid.add(lb3, 0, 2, 1, 1);
		grid.add(ta, 1, 2, 1, 1);
		grid.add(chooseFile, 0, 3, 1, 1);
		grid.add(lbPath, 1, 3, 2, 1);
		grid.add(choice, 1, 4, 2, 1);
		grid.add(bt1, 1, 5, 1, 1);
		
		GridPane.setHalignment(lb1, HPos.CENTER);
		GridPane.setHalignment(lb3, HPos.RIGHT);
		GridPane.setHalignment(bt1, HPos.RIGHT);
		GridPane.setHalignment(lb2, HPos.CENTER);

		stage.setScene(scene);
		stage.show();
		stage.setTitle("Study Buddy");
		stage.setResizable(false);
		
		//Accion del botón para crear
		bt1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ImageManager im = new ImageManager();
				im.addImage(tf.getText(), ta.getText(), choice.getSelectionModel().getSelectedItem(), url);
				stage.close();
			}
		});
		//Acción para abrir archivos
		chooseFile.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				FileChooser fileChooser = new FileChooser();
	            //Set extension filter
	            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
	            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
	            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
	            //Show open file dialog
	            File file = fileChooser.showOpenDialog(null);
	            
				url = file.toURI().toString();
				
	            lbPath.setText(file.getAbsolutePath());
			}
		});
		
	
	}
	//Obtiene los nombres de las materias en el archivo
	public static ArrayList<String> getSubjectNames() {
		SubjectManager sb = new SubjectManager();
		return sb.getSubjectNames();
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}

}
