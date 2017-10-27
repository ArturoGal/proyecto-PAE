package proyectoPAE;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class NewSubject2 extends Application {
	private ResourceBundle rb;
	@Override
	public void start(Stage stage) throws Exception {
		System.getProperty("user.language");
		String resourceLocation = "resources.i18n.messages";
		Locale locale = new Locale("EN");
		rb = ResourceBundle.getBundle(resourceLocation, locale);
		
		GridPane grid = new GridPane();
		grid.setHgap(15);
		grid.setPrefSize(475, 300);
		grid.setVgap(15);
		grid.setPadding(new Insets(15));
		Scene scene = new Scene(grid);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Button bt1 = new Button(rb.getString("main_addBtn"));
		Label lb1 = new Label(rb.getString("main_newSubjectLb"));
		lb1.setStyle("-fx-font-size: 24px");
		
		Label lb2 = new Label(rb.getString("main_nameLb"));
		Label lb3 = new Label(rb.getString("main_descriptionLb"));
		TextField tf = new TextField();
		TextArea ta = new TextArea();
		ta.setPrefSize(314, 136);
		
		grid.add(lb1, 0, 0, 2, 1);
		grid.add(lb2, 0, 1, 1, 1);
		grid.add(tf, 1, 1, 1, 1);
		grid.add(lb3, 0, 2, 1, 1);
		grid.add(ta, 1, 2, 1, 1);
		grid.add(bt1, 1, 3, 1, 1);
		
	
		GridPane.setHalignment(lb1, HPos.CENTER);
		GridPane.setHalignment(lb3, HPos.RIGHT);
		GridPane.setHalignment(bt1, HPos.RIGHT);
		GridPane.setHalignment(lb2, HPos.CENTER);
		
		
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Study Buddy");
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
