package proyectoPAE;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Settings2 extends Application {
	private ResourceBundle rb;

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.getProperty("user.language");
		String resourceLocation = "resources.i18n.messages";
		Locale locale = new Locale("EN");
		rb = ResourceBundle.getBundle(resourceLocation, locale);
		
		VBox vBox = new VBox(); 
		Label lblsett = new Label(rb.getString("main_settingsBtn"));
		Button btnEdit = new Button(rb.getString("main_editSubjectsBtn")); 
		Button btnFiles = new Button(rb.getString("main_editFilesBtn")); 
		Button btnAbout = new Button(rb.getString("main_aboutBtn")); 
		Button btnHelp = new Button(rb.getString("main_helpBtn")); 
		
		VBox.setMargin(lblsett, new Insets(10,180,10,180));
		VBox.setMargin(btnEdit, new Insets(5,180,5,180));
		VBox.setMargin(btnFiles, new Insets(5,180,5,180));
		VBox.setMargin(btnAbout, new Insets(5,180,5,180));
		VBox.setMargin(btnHelp, new Insets(5,180,5,180));
		
		lblsett.setAlignment(Pos.CENTER);
		lblsett.setMaxWidth(114);
		lblsett.setMaxHeight(34);
		lblsett.setStyle("-fx-font-size: 24;");
		
		btnEdit.setAlignment(Pos.CENTER);
		btnEdit.setMinWidth(115);
		btnEdit.setMinHeight(50);
		
		btnFiles.setAlignment(Pos.CENTER);
		btnFiles.setMinWidth(115);
		btnFiles.setMinHeight(50);
		
		btnAbout.setAlignment(Pos.CENTER);
		btnAbout.setMinWidth(115);
		btnAbout.setMinHeight(50);
		
		btnHelp.setAlignment(Pos.CENTER);
		btnHelp.setMinWidth(115);
		btnHelp.setMinHeight(50);
		
		vBox.getChildren().addAll(lblsett, btnEdit, btnFiles, btnAbout, btnHelp ); 
		
		//Se agrega el VBox al Scence
		Scene scene = new Scene (vBox);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//Se ajustan las prioridades del Stage y se agrega el Scence
		primaryStage.setTitle("Study Buddy"); 
		primaryStage.setScene(scene);
		primaryStage.show();
		
		btnEdit.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Subjects2 sub = new Subjects2();
				Stage stage = new Stage();
				try {
					sub.start(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//	Scene subScene = new Scene(sub.start(stage), 200, 100);
				
			}	
		});
		
		}
		public static void main(String[] args) {
			launch(args);
		}

	}