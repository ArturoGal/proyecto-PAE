package proyectoPAE;

import java.awt.im.InputContext;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class OurImageView extends Application {
	private OurImage ourImage;
	private ResourceBundle rb;
	public OurImageView(OurImage ourImage){
		this.ourImage = ourImage;
	}

	@Override
	public void start(Stage stage) throws Exception {
		System.getProperty("user.language");
		String resourceLocation = "resources.i18n.messages";
		InputContext context = InputContext.getInstance();  
		Locale locale = context.getLocale();
		rb = ResourceBundle.getBundle(resourceLocation, locale);
		
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Image image = new Image(ourImage.getURL());
		ImageView imgView = new ImageView(image);

		grid.setHgap(15);
		
		grid.setVgap(15);
		grid.setPadding(new Insets(15));
	
		//Botón para ver los detalles de la imagen
		Button bt1 = new Button(rb.getString("main_see"));
		Label lb1 = new Label();
		Label textContent = new Label();
		textContent.setWrapText(true);
		textContent.setStyle("-fx-font-weight: NORMAL");
		textContent.setTextAlignment(TextAlignment.JUSTIFY);
		lb1.setStyle("-fx-font-size: 24px");
		GridPane.setHalignment(lb1, HPos.CENTER);
		GridPane.setHalignment(bt1, HPos.RIGHT);
		
		GridPane.setConstraints(bt1, 0, 3, 1, 1);
		GridPane.setConstraints(lb1, 0, 0, 1, 1);
		GridPane.setConstraints(imgView, 0, 1, 1, 1);
		GridPane.setConstraints(textContent, 0, 2, 1, 1);
		grid.getChildren().addAll(bt1, lb1, textContent, imgView);
		//Acción para el botón de ver los detalles de la imagen
		bt1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				lb1.setText(ourImage.getTitle());
				textContent.setText(ourImage.getDescription());
			}
		});
		
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
