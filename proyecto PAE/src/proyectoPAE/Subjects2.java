package proyectoPAE;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Subjects2 extends Application {
	private ResourceBundle rb;
	public void start(Stage stage) throws Exception {
		System.getProperty("user.language");
		String resourceLocation = "resources.i18n.messages";
		Locale locale = new Locale("EN");
		rb = ResourceBundle.getBundle(resourceLocation, locale);
		
		GridPane grid = new GridPane();
		grid.setPrefSize(475, 300);
		grid.setHgap(15);
		grid.setVgap(15);
		grid.setPadding(new Insets(15));
		Scene scene = new Scene(grid);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Label lb1 = new Label(rb.getString("main_subjectsLb"));
		Label lb2 = new Label("Enter text");
		ListView<String> lv = new ListView<String>();
		TextField tf = new TextField();
		Button bt1 = new Button(rb.getString("main_addBtn"));
		Button bt2 = new Button(rb.getString("main_deleteBtn"));
		
		lb1.setStyle("-fx-font-size: 24px");
		

		ObservableList<String> listItems = FXCollections.observableArrayList("Add Items here");
		
		lv.setItems(listItems);
		GridPane.setHalignment(lb1, HPos.CENTER);
		GridPane.setHalignment(bt1, HPos.CENTER);
		GridPane.setHalignment(bt2, HPos.CENTER);
		GridPane.setValignment(bt2, VPos.TOP);

		grid.add(lb1, 0, 0, 2, 1);
		grid.add(lv, 0, 1, 1, 4);
		grid.add(lb2, 1, 1, 1, 1);
		grid.add(tf, 1, 2, 1, 1);
		grid.add(bt1, 1, 3, 1, 1);
		grid.add(bt2, 1, 4, 1, 1);

		
	
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Study Buddy");
		
	}	
	
	public static void main(String[] args) {
		launch(args);
	}
}