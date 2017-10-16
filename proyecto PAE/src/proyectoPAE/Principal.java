package proyectoPAE;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

	public class Principal extends Application {

	private Stage primaryStage; 
	private GridPane rootPane;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		showPrincipal(); 
	}
	
	public void showPrincipal(){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Principal.fxml"));
			rootPane = (GridPane) loader.load();
			Scene scene = new Scene(rootPane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Study Buddy");
			primaryStage.setScene(scene);
			Controller controller = loader.getController(); 
			controller.setPrincipal(this); 
			primaryStage.show();
		/*	GridPane root = FXMLLoader.load(getClass().getResource("Principal (1).fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Button btnAdd = new Button();
			
			btnAdd.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					try {
						GridPane root = FXMLLoader.load(getClass().getResource("Subjects.fxml"));
						Scene scene = new Scene(root);
						primaryStage.setScene(scene);
						primaryStage.show();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
			
		*/
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void mostrarVentanaSecundaria() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Subjects.fxml"));
            GridPane subjects = (GridPane) loader.load();
            Stage ventana = new Stage();
            ventana.setTitle("Venta Dos");
            ventana.initOwner(primaryStage);
            Scene scene = new Scene(subjects);
            ventana.setScene(scene);
            Controller controller = loader.getController();
            controller.setPrincipalStage(ventana);
            ventana.show();
 
        } catch (Exception e) {
            //tratar la excepción
        }
    }
	
	public static void main(String[] args) {
		launch(args);
	}		
}