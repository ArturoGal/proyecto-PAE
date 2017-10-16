package proyectoPAE;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class NewFlashCardController implements Initializable {
	
	@FXML private Button titleLb;
	@FXML private Button descriptionLb;
	private ResourceBundle bundle;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	bundle = resources;
	String resourceLocation = "resources.i18n.messages";
	Locale locale = new Locale("EN");
	bundle = ResourceBundle.getBundle(resourceLocation, locale);
	titleLb.setText(bundle.getString("main_titleLb"));
	descriptionLb.setText(bundle.getString("main_descriptionLb"));
	}

}
