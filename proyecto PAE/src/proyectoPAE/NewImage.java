package proyectoPAE;

import java.io.File;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class NewImage extends Application {

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
		grid.setGridLinesVisible(true);
		Scene scene = new Scene(grid);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Button bt1 = new Button(rb.getString("main_addBtn"));
		Label lb1 = new Label(rb.getString("main_newImageLb"));
		lb1.setStyle("-fx-font-size: 24px");
		
		Label lb2 = new Label(rb.getString("main_nameLb"));
		Label lb3 = new Label(rb.getString("main_descriptionLb"));
		Button chooseFile = new Button(rb.getString("main_browse"));
		Label lbPath = new Label();
		TextField tf = new TextField();
		TextArea ta = new TextArea();
		ta.setPrefSize(314, 136);
		
		grid.add(lb1, 0, 0, 2, 1);
		grid.add(lb2, 0, 1, 1, 1);
		grid.add(tf, 1, 1, 1, 1);
		grid.add(lb3, 0, 2, 1, 1);
		grid.add(ta, 1, 2, 1, 1);
		grid.add(chooseFile, 0, 3, 1, 1);
		grid.add(lbPath, 1, 3, 2, 1);
		grid.add(bt1, 1, 4, 1, 1);
		
		GridPane.setHalignment(lb1, HPos.CENTER);
		GridPane.setHalignment(lb3, HPos.RIGHT);
		GridPane.setHalignment(bt1, HPos.RIGHT);
		GridPane.setHalignment(lb2, HPos.CENTER);

		
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Study Buddy");
		
		bt1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				stage.close();
			}
		});
		
		chooseFile.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				FileChooser fileChooser = new FileChooser();
	             
	            //Set extension filter
	            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
	            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
	            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
	              
	            //Show open file dialog
	            File file = fileChooser.showOpenDialog(null);
	            lbPath.setText(file.getAbsolutePath());
			}
		});
		
	
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}

}
