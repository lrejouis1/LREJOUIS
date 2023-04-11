package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

/**
 * The Class Main.
 */
public class Main extends Application {

	/** The primary stage. */
	private static Stage primaryStage;

	/**
	 * Start.
	 *
	 * @param primaryStage the primary stage
	 */
	public void start(Stage primaryStage) {

		Main.primaryStage = primaryStage;

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));

			BorderPane root = new BorderPane();

			root.setCenter(loader.load());

			Scene scene = new Scene(root);

			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Change scene.
	 *
	 * @param fxml the fxml
	 */
	public static void changeScene(String fxml) {

		FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxml));

		BorderPane root = new BorderPane();

		try {

			root.setCenter(loader.load());

		} catch (IOException e) {
			e.printStackTrace();
		}
		primaryStage.getScene().setRoot(root);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
