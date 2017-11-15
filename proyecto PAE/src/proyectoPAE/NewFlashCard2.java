package proyectoPAE;


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
import javafx.stage.Stage;

public class NewFlashCard2 extends Application {
	private ResourceBundle rb;
	

	@Override
	public void start(Stage stage) throws Exception {
		System.getProperty("user.language");
		String resourceLocation = "resources.i18n.messages";
		Locale locale = new Locale("En");
		rb = ResourceBundle.getBundle(resourceLocation, locale);
		

		GridPane grid = new GridPane();
		Scene scene = new Scene(grid);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		grid.setHgap(15);
		grid.setPrefSize(475, 300);
		grid.setVgap(15);
		grid.setPadding(new Insets(15));
		
		Button bt1 = new Button(rb.getString("main_createBtn"));
		Label lb1 = new Label(rb.getString("main_flashCardLb"));
		Label lb2 = new Label(rb.getString("main_titleLb"));
		Label lb3 = new Label("    "+rb.getString("main_contentLb"));
		TextField tf = new TextField();
		TextArea ta = new TextArea();
		ChoiceBox<String> choice = new ChoiceBox<String>();
		choice.setPrefWidth(315);
		ObservableList<String> listSubjects = FXCollections.observableArrayList(getSubjectNames());
		choice.getItems().addAll(listSubjects);
		ta.setPrefSize(315, 80);
		ta.setWrapText(true);
		lb1.setStyle("-fx-font-size: 24px");
		GridPane.setHalignment(lb1, HPos.CENTER);
		GridPane.setHalignment(lb3, HPos.RIGHT);
		GridPane.setHalignment(bt1, HPos.RIGHT);
		GridPane.setHalignment(lb2, HPos.CENTER);	
		
		GridPane.setConstraints(bt1, 1, 4, 1, 1);
		GridPane.setConstraints(lb1, 0, 0, 2, 1);
		GridPane.setConstraints(lb2, 0, 1, 1, 1);
		GridPane.setConstraints(tf, 1, 1, 1, 1);
		GridPane.setConstraints(lb3, 0, 2, 1, 1);
		GridPane.setConstraints(choice, 1, 3, 2, 1);
		GridPane.setConstraints(ta, 1, 2, 1, 1);
		grid.getChildren().addAll(bt1, lb1, lb2, tf, lb3, ta, choice);
		
		bt1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				FlashCardManager fcm = new FlashCardManager();
				fcm.addFlashCard(tf.getText(), ta.getText(), choice.getSelectionModel().toString());
				stage.close();
			}
		});
		
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Study Buddy");
			
	}
	
	public static ArrayList<String> getSubjectNames() {
		SubjectManager sb = new SubjectManager();
		return sb.getSubjectNames();
	}
	
	public static void main(String[] args) {
		launch(args);
	
	}

}