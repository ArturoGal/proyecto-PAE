package proyectoPAE;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class SubjectView extends Application {
	private Subject subject;
	public SubjectView(Subject subject){
		this.subject = subject;
	}

	@Override
	public void start(Stage stage) throws Exception {
		//Ventana para ver la descripción de la materia
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		grid.setHgap(15);
		grid.setPrefSize(475, 300);
		grid.setVgap(15);
		grid.setPadding(new Insets(15));
		grid.getColumnConstraints().add(new ColumnConstraints(460)); 
		Label lb1 = new Label(subject.getName());

		Label textContent = new Label(subject.getDescription());
		textContent.setWrapText(true);
		textContent.setStyle("-fx-font-weight: NORMAL");
		textContent.setTextAlignment(TextAlignment.JUSTIFY);
		lb1.setStyle("-fx-font-size: 24px");
		GridPane.setHalignment(lb1, HPos.CENTER);
		
		GridPane.setConstraints(lb1, 0, 0, 1, 1);
		GridPane.setConstraints(textContent, 0, 1, 1, 1);
		grid.getChildren().addAll(lb1, textContent);

		
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Study Buddy");
		stage.setResizable(false);
			
	}
	
	public static ArrayList<String> getSubjectNames() {
		SubjectManager sb = new SubjectManager();
		return sb.getSubjectNames();
	}
	
	public static void main(String[] args) {
		launch(args);
	
	}
}
