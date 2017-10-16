package proyectoPAE;

import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class NewFlashCard extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			String resourcesLocation = "resources.i18n.messages";
			ResourceBundle rb = ResourceBundle.getBundle(resourcesLocation);
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setResources(rb);
			Pane pane = (GridPane)fxmlLoader.load(this.getClass().getResource("NewFlashCard.fxml").openStream());
			Scene scene = new Scene(pane);
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