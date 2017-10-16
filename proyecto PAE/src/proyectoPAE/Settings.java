package proyectoPAE;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Settings extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			VBox root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Study Buddy");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}		

}
