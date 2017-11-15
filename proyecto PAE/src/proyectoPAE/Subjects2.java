package proyectoPAE;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Subjects2 extends Application {
	private ResourceBundle rb;
	public void start(Stage stage) throws Exception {
		System.getProperty("user.language");
		String resourceLocation = "resources.i18n.messages";
		Locale locale = new Locale("EN");
		rb = ResourceBundle.getBundle(resourceLocation, locale);
		
		GridPane grid = new GridPane();
		//grid.setGridLinesVisible(true);
		grid.setPrefSize(475, 300);
		grid.setHgap(15);
		grid.setVgap(15);
		grid.setPadding(new Insets(15));
		Scene scene = new Scene(grid);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Label lb1 = new Label(rb.getString("main_subjectsLb"));
	
		ListView<String> lv = new ListView<String>();
		
		Button bt2 = new Button(rb.getString("main_deleteBtn"));
		bt2.setPrefWidth(180);
		lb1.setStyle("-fx-font-size: 24px");
		
		ObservableList<String> listSubjects = FXCollections.observableArrayList(new SubjectManager().getSubjectNames());
		lv.setItems(listSubjects);
		
		GridPane.setHalignment(lb1, HPos.CENTER);
		GridPane.setHalignment(bt2, HPos.CENTER);
		GridPane.setValignment(bt2, VPos.CENTER);

		grid.add(lb1, 0, 0, 2, 1);
		grid.add(lv, 0, 1, 1, 1);
		grid.add(bt2, 1, 1, 1, 1);
		
		bt2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SubjectManager sb = new SubjectManager();
				sb.deleteSubject(lv.getSelectionModel().getSelectedItem());
				ObservableList<String> listSubjects = FXCollections.observableArrayList(new SubjectManager().getSubjectNames());
				lv.setItems(listSubjects);
			}
		});
		
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Study Buddy");
		
	}	
	
	public static void main(String[] args) {
		launch(args);
	}
}