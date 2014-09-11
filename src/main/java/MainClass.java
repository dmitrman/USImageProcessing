import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.mathworks.toolbox.javabuilder.MWException;

public class MainClass extends Application {

	public static void main(String[] args) throws MWException {
		Application.launch(MainClass.class, (java.lang.String[])null);			
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource(
				"fxmls/MainView.fxml"));
		Scene scene = new Scene(root, 300, 275);
		stage.setTitle("FXML Welcome");
		stage.setScene(scene);
		stage.show();
	}
}
