package proyectoPAE;


import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class NewFlashCardController implements Initializable {
	
	@FXML private Label titleLb;
	@FXML private Label descriptionLb;
	@FXML private Label newFlashCardTitle;
	@FXML private Button createBtn;
	@FXML private TextField flashCardTitle;
	@FXML private TextArea flashCardDescription;
	private ResourceBundle bundle;
	String flashCardTitleS;
	String flashCardDescriptionS;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	bundle = resources;
	String resourceLocation = "resources.i18n.messages";
	Locale locale = new Locale("EN");
	bundle = ResourceBundle.getBundle(resourceLocation, locale);
	titleLb.setText(bundle.getString("main_titleLb"));
	descriptionLb.setText(bundle.getString("main_descriptionLb"));
	newFlashCardTitle.setText(bundle.getString("main_flashCardLb"));
	createBtn.setText(bundle.getString("main_createBtn"));
	}
	
	public void buttonActionCreate(){
		flashCardTitleS = flashCardTitle.getText();
		flashCardDescriptionS = flashCardTitle.getText();
	}

}
