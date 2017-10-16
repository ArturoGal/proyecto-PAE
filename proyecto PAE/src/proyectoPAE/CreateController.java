package proyectoPAE;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CreateController implements Initializable {
	@FXML private Label titleLb;
	@FXML private Label descriptionLb;
	@FXML private Label createTitleLb;
	@FXML private Label subjectLb;
	@FXML private Label toolLb;
	@FXML private Button okBtn;
	private ResourceBundle bundle;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	bundle = resources;
	String resourceLocation = "resources.i18n.messages";
	Locale locale = new Locale("ES");
	bundle = ResourceBundle.getBundle(resourceLocation, locale);
	titleLb.setText(bundle.getString("main_titleLb"));
	descriptionLb.setText(bundle.getString("main_descriptionLb"));
	createTitleLb.setText(bundle.getString("main_createTitleLb"));
	okBtn.setText(bundle.getString("main_okBtn"));
	subjectLb.setText(bundle.getString("main_subjectLb"));
	toolLb.setText(bundle.getString("main_toolLb"));
	}
	


}