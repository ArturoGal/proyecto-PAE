package proyectoPAE;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FlashCardView extends Application {
	FlashCard flash;
	
	public FlashCardView(FlashCard flash){
		this.flash = flash;
	}

	@Override
	public void start(Stage arg0) throws Exception {
		BorderPane border = new BorderPane();
		border.setCenter(new Label(flash.getDescription()));
		
	}
	
}
