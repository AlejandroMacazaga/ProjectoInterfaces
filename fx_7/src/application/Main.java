package application;
	
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Seleccion de idioma (Español como base en caso de no existir fichero de idiomas)
			Locale locale = new Locale("es", "ES");
			BufferedReader br = new BufferedReader(new FileReader(new File("language")));
			String line;
			if((line = br.readLine()) != null) {
				locale = new Locale(line.trim().substring(0, line.trim().indexOf(' ') ), line.trim().substring(line.trim().indexOf(' ') + 1 ));
			}
			br.close();
			
			ResourceBundle bundle = ResourceBundle.getBundle("strings", locale);
			GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("/views/tabla.fxml"), bundle);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.getIcons().add(new Image("file:table.png"));
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
