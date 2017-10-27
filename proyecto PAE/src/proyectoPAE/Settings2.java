package proyectoPAE;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Settings2 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		VBox vBox = new VBox(); 
		
		Label lblsett = new Label("Settings");
		Button btnEdit = new Button("Edit Subjects"); 
		Button btnFiles = new Button("Edit Files"); 
		Button btnAbout = new Button("About"); 
		Button btnHelp = new Button("Help"); 
		
		vBox.setMargin(lblsett, new Insets(10,180,10,180));
		vBox.setMargin(btnEdit, new Insets(5,180,5,180));
		vBox.setMargin(btnFiles, new Insets(5,180,5,180));
		vBox.setMargin(btnAbout, new Insets(5,180,5,180));
		vBox.setMargin(btnHelp, new Insets(5,180,5,180));
		
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
		primaryStage.setTitle("VBox Example"); 
		primaryStage.setScene(scene);
		primaryStage.show();
		}
		public static void main(String[] args) {
			launch(args);
		}

	}

 
