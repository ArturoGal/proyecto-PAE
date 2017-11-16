package proyectoPAE;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Create2 extends Application{
	private ResourceBundle rb;
	public void start(Stage primaryStage) {
		System.getProperty("user.language");
		String resourceLocation = "resources.i18n.messages";
		Locale locale = new Locale("Ean");
		rb = ResourceBundle.getBundle(resourceLocation, locale);
		//Instancia del Grid Pane
		GridPane gp = new GridPane(); 
		gp.setPrefSize(475, 300);
		//Configura el padding
		gp.setPadding(new Insets(15));
		//Se declara la etiqueta del nombre
		Label create = new Label(rb.getString("main_createTitleLb"));
		Label lblTitle =  new Label(rb.getString("main_titleLb")); 
		Label lblDes= new Label(rb.getString("main_descriptionLb")); 
		Label lblSub = new Label(rb.getString("main_subjectLb")+":"); 
		Label lblTool = new Label(rb.getString("main_toolLb")); 
		TextField txtTitle = new TextField(); 
		TextArea txtDes= new TextArea(); 
		ChoiceBox<String> cbSub = new ChoiceBox<>(); 
		//CheckBox cb1 = new CheckBox(rb.getString("main_mindMapCb"));
		CheckBox cb2 = new CheckBox(rb.getString("main_flashCardCb"));
		CheckBox cb3 = new CheckBox(rb.getString("main_chartCb"));
	//	CheckBox cb4 = new CheckBox(rb.getString("main_tableCb"));
		Button ok = new Button("OK"); 
		
		txtTitle.setPrefWidth(600);
		txtDes.setPrefWidth(600);
		txtDes.setWrapText(true);
		cbSub.setPrefWidth(270);			
		
		create.setStyle("-fx-font-size: 22;  ");
		GridPane.setHalignment(create, HPos.CENTER);
		//GridPane.setValignment(cb4, VPos.TOP);
		
		//Espaciado entre columnas y filas 
		gp.setVgap(15); 
	    gp.setHgap(15);
	    
	    //Se agregan los nodos al GridPane
	    gp.add(create, 0, 0, 3, 1); 
	    gp.add(lblTitle, 0, 1);
	    gp.add(lblDes, 0, 2);
	    gp.add(lblSub, 0, 3);
	    gp.add(lblTool, 0, 4);
	    gp.add(ok, 2, 6); 
	    gp.add(txtTitle, 1, 1, 2, 1);
	    gp.add(txtDes, 1, 2, 2, 1);
	    gp.add(cbSub, 1, 3);
	    gp.add(cb2, 1, 4);
	    gp.add(cb3, 1, 5);
	   // gp.add(cb3, 1, 6); 
	    //gp.add(cb4, 1, 7);
	    
	    //Se agrega el GridPane al Scence
	    Scene scene = new Scene (gp); 
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//Se ajustan las prioridades del Stage y se agrega el Scence
		primaryStage.setTitle("Study Buddy"); 
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}