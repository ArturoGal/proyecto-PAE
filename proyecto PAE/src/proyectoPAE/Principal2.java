package proyectoPAE;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Principal2 extends Application {
	private ResourceBundle rb;
	@Override
	public void start(Stage stage) throws Exception {
		
		System.getProperty("user.language");
		String resourceLocation = "resources.i18n.messages";
		Locale locale = new Locale("En");
		rb = ResourceBundle.getBundle(resourceLocation, locale);
		
		GridPane grid = new GridPane();
		grid.setHgap(15);
		grid.setPrefSize(600, 500);
		grid.setVgap(15);
		grid.setPadding(new Insets(15));
		Scene scene = new Scene(grid);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Button bt1 = new Button(rb.getString("main_createBtn"));
		Button bt2 = new Button(rb.getString("main_addBtn"));
		Button bt3 = new Button(rb.getString("main_settingsBtn"));
		Label lb1 = new Label("Study Buddy");
		Label lb2 = new Label(rb.getString("main_subjectLb"));
		ListView<String> lv1 = new ListView<String>();
		ListView<String> lv2 = new ListView<String>();
		TextArea ta1 = new TextArea();
		TextArea ta2 = new TextArea();
		lv1.setPrefWidth(270);
		lv2.setPrefWidth(270);
		
		
		ObservableList<String> listSubjects = FXCollections.observableArrayList(getSubjectNames());

		ObservableList<String> listTools = FXCollections.observableArrayList("Add Tools here");
		
		lv1.setItems(listSubjects);
		lv2.setItems(listTools);
		
		lb1.setStyle("-fx-font-size: 30px");
		lb2.setStyle("-fx-font-size: 20px");
		ta1.setPrefSize(200, 300);
		ta2.setPrefSize(350, 300);
		bt1.setPrefWidth(150);
		bt2.setPrefWidth(200);
		
		grid.add(lb1, 0, 0, 2, 1);
		grid.add(lb2, 0, 1, 1, 1);
		grid.add(bt1, 1, 1, 1, 1);
		grid.add(lv1, 0, 2, 1, 1);
		grid.add(lv2, 1, 2, 1, 1);
		grid.add(bt3, 1, 3, 1, 1);
		grid.add(bt2, 0, 3, 1, 1);
	
		GridPane.setHalignment(lb1, HPos.CENTER);
		GridPane.setHalignment(bt1, HPos.CENTER);
		GridPane.setHalignment(lb2, HPos.CENTER);
		GridPane.setHalignment(bt3, HPos.RIGHT);
		GridPane.setHalignment(bt2, HPos.CENTER);
		
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Study Buddy");
	
	}
	
	public static void main(String[] args) {
		launch(args);
		System.out.println("Hola");
	}
	
	public static ArrayList<String> getSubjectNames() {
		SubjectManager sb = new SubjectManager();
		return sb.getSubjectNames();
	}
	
}