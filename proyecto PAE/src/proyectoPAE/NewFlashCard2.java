package proyectoPAE;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.application.Platform;
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
import javafx.stage.Stage;

public class NewFlashCard2 extends Application {
	private ResourceBundle rb;
	@Override
	public void start(Stage stage) throws Exception {
		System.getProperty("user.language");
		String resourceLocation = "resources.i18n.messages";
		Locale locale = new Locale("En");
		rb = ResourceBundle.getBundle(resourceLocation, locale);

		GridPane grid = new GridPane();
		Scene scene = new Scene(grid);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		grid.setHgap(15);
		grid.setPrefSize(475, 300);
		grid.setVgap(15);
		grid.setPadding(new Insets(15));
		
		Button bt1 = new Button(rb.getString("main_createBtn"));
		Label lb1 = new Label(rb.getString("main_flashCardLb"));
		Label lb2 = new Label(rb.getString("main_titleLb"));
		Label lb3 = new Label("    "+rb.getString("main_contentLb"));
		TextField tf = new TextField();
		TextArea ta = new TextArea();
		ta.setPrefSize(314, 136);
		ta.setWrapText(true);
		lb1.setStyle("-fx-font-size: 24px");

		GridPane.setHalignment(lb1, HPos.CENTER);
		GridPane.setHalignment(lb3, HPos.RIGHT);
		GridPane.setHalignment(bt1, HPos.RIGHT);
		GridPane.setHalignment(lb2, HPos.CENTER);	
		
		GridPane.setConstraints(bt1, 1, 3, 1, 1);
		GridPane.setConstraints(lb1, 0, 0, 2, 1);
		GridPane.setConstraints(lb2, 0, 1, 1, 1);
		GridPane.setConstraints(tf, 1, 1, 1, 1);
		GridPane.setConstraints(lb3, 0, 2, 1, 1);
		GridPane.setConstraints(ta, 1, 2, 1, 1);
		grid.getChildren().addAll(bt1, lb1, lb2, tf, lb3, ta);
		
		bt1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String title = tf.getText();
				String content = ta.getText();

				try {
					writeToFile(title, content);
				} catch (IOException e) {
					e.printStackTrace();
				}
				Platform.exit();
			}
		});
		
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Study Buddy");
			
	}
	
	public static void writeToFile(String title, String content) throws IOException{
		Path path = Paths.get("files\\"+title+".txt");
		FileChannel outChannel = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		ByteBuffer bb = ByteBuffer.allocate(content.length());
		bb.asCharBuffer();
		CharBuffer cb = CharBuffer.allocate(content.length());
		for(char c : content.toCharArray()){
			cb.put(c);
		}
		cb.flip();
		Charset cSet = Charset.forName("UTF-8"); 
		CharsetEncoder encoder = cSet.newEncoder();
		bb = encoder.encode(cb);
		outChannel.write(bb);
		outChannel.close();
	}

	public static void main(String[] args) {
		launch(args);
	
	}

}