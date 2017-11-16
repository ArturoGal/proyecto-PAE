package proyectoPAE;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FlashCardView extends Application {
	FlashCard flash;
	
	public FlashCardView(FlashCard flash){
		this.flash = flash;
	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane border = new BorderPane();
		border.setCenter(new Label(flash.getContent()));
		border.setTop(new Label(flash.getName()));
		Scene scene = new Scene(border);
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Study Buddy");
		stage.setResizable(false);
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}
