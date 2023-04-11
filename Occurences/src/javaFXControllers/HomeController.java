package javaFXControllers;

import java.io.IOException;
import application.Occurences;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class HomeController.
 */
public class HomeController {

	/** The file name field. */
	@FXML
	private TextField fileNameField;

	/** The get stat btn. */
	@FXML
	private Button getStatBtn;

	/** The occurences list view. */
	@FXML
	private ListView<String> occurencesListView;

	/** The scroll pane. */
	@FXML
	private ScrollPane scrollPane;

	/**
	 * On click get stat.
	 *
	 * @param event the event
	 */
	@FXML
	void onClickGetStat(ActionEvent event) {
		String filePath = fileNameField.getText().toString();
		try {
			String fileContent = Occurences.readFileToString(filePath);
			System.out.println("File Content: \n" + fileContent);
			Occurences.countWordOccurrences(fileContent);
			Occurences.sortByOccurrences();
			Occurences.printMap();
			Occurences.updateOccurencesList();
			occurencesListView.setItems(Occurences.getOccurencesList());
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
		}

	}

	/**
	 * Initialize.
	 */
	@FXML
	public void initialize() {
		scrollPane.setContent(occurencesListView);
		scrollPane.setFitToHeight(true);
		fileNameField.setPromptText("Enter linked path");
		fileNameField.getParent().requestFocus();

		occurencesListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {

			}
		});
	}

}
