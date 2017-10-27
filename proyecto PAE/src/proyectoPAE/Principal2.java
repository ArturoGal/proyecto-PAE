package proyectoPAE;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Principal2 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		GridPane grid = new GridPane();
		grid.setHgap(15);
		grid.setPrefSize(600, 500);
		grid.setVgap(15);
		grid.setPadding(new Insets(15));
		Scene scene = new Scene(grid);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Button bt1 = new Button("+ CREATE");
		Button bt2 = new Button("+ ADD");
		Button bt3 = new Button("Settings");
		Label lb1 = new Label("Study Buddy");
		Label lb2 = new Label("Subject");
		Label lb3 = new Label("   Description:    ");
		TextArea ta1 = new TextArea();
		TextArea ta2 = new TextArea();
		
		lb1.setStyle("-fx-font-size: 30px");
		lb2.setStyle("-fx-font-size: 20px");
		ta1.setPrefSize(200, 300);
		ta2.setPrefSize(350, 300);
		bt1.setPrefWidth(150);
		bt2.setPrefWidth(200);
		
		grid.add(lb1, 0, 0, 2, 1);
		grid.add(lb2, 0, 1, 1, 1);
		grid.add(bt1, 1, 1, 1, 1);
		grid.add(ta1, 0, 2, 1, 1);
		grid.add(ta2, 1, 2, 1, 1);
		grid.add(bt3, 1, 3, 1, 1);
		grid.add(bt2, 0, 3, 1, 1);
	
		GridPane.setHalignment(lb1, HPos.CENTER);
		GridPane.setHalignment(lb3, HPos.RIGHT);
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
	}
}