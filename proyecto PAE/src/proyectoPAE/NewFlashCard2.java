package proyectoPAE;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewFlashCard2 extends Application {


	@Override
	public void start(Stage stage) throws Exception {
		GridPane grid = new GridPane();
		grid.setHgap(15);
		grid.setPrefSize(475, 300);
		grid.setVgap(15);
		grid.setPadding(new Insets(15));
		Scene scene = new Scene(grid);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Button bt1 = new Button("CREATE");
		Label lb1 = new Label("NEW FLASHCARD");
		lb1.setStyle("-fx-font-size: 24px");
		
		Label lb2 = new Label("Name: ");
		Label lb3 = new Label("   Description:    ");
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