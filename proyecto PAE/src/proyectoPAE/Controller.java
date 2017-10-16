package proyectoPAE;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;


public class Controller implements Initializable{
	
	private Principal principal;
	private Stage stage;
	
	@FXML public Button btnAdd; 
	@FXML public Button btnSettings; 
	@FXML public Button btnCreate;
	
	private void newWindow(ActionEvent event){
		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				principal.mostrarVentanaSecundaria();
			}
		});
		
	}
	public void setPrincipal(Principal primaryProgram){
		this.principal = primaryProgram; 
	}

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public void setPrincipalStage(Stage ventana) {
		// TODO Auto-generated method stub
		this.stage = ventana; 
	} 

}
