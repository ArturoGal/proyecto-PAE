package proyectoPAE;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class About extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		//Ventana para ver información acerca de la materia
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		grid.setHgap(15);
		grid.setPrefSize(475, 300);
		grid.setVgap(15);
		grid.setPadding(new Insets(15));
		grid.getColumnConstraints().add(new ColumnConstraints(460)); 
		
		Label about = new Label("About Study Buddy");
		Label textContent = new Label("Study Buddy te ayudará a estudiar de una forma más sencilla y didacta");
		Label textCon = new Label("Creadores:\nAndrea Rayón 'Rayón'\nArturo García 'El Diablo'");
		Label version = new Label("Version 1.0");
		about.setStyle("-fx-font-size: 32px");
		textContent.setWrapText(true);
		textContent.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(textContent, HPos.CENTER);
		GridPane.setHalignment(textCon, HPos.CENTER);
		GridPane.setHalignment(about, HPos.CENTER);
		GridPane.setHalignment(version, HPos.CENTER);

		GridPane.setConstraints(about, 0, 0, 1, 1);
		GridPane.setConstraints(textContent, 0, 1, 1, 1);
		GridPane.setConstraints(textCon, 0, 2, 1, 1);
		GridPane.setConstraints(version, 0, 3, 1, 1);
		grid.getChildren().addAll(textContent, textCon, about, version);

		
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Study Buddy");
		stage.setResizable(false);
			
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
