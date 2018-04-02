/*
 * CS2852 – 031
 * Spring 2017
 * Lab 4 - Autocomplete
 * Name: Stuart Enters
 * Created: 3/28/2018
 */

package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * The controller for the autocomplete application
 */
public class Controller {
    private File file = new File(
            "file:///C:/Users/enterss/Documents/GitHub/CS2852/Labs/Lab4/2000words.txt");
    private AutoCompleter strategy;

    /**
     * Menu for selecting stratgey
     */
    @FXML
    public Menu strategyMenu;

    /**
     * Text Field for user input
     */
    @FXML
    public TextField searchTextField;

    /**
     * Text Area to write Matched words to
     */
    @FXML
    public TextArea matchTextArea;

    /**
     *The label for recording the time the operation took
     */
    @FXML
    public Label timeLabel;
    /**
     * The label for counting the number of matches
     */
    @FXML
    public Label matchCounterLabel;

    /**
     * Method for loading a new dictionary file
     */
    @FXML
    public void handleOpen() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Select a dictionary to load");
        chooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        file = chooser.showOpenDialog(new Stage());

        strategyMenu.setDisable(false);
    }

    /**
     * Method for checking if the enter key was pressed
     */
    @FXML
    public void checkKey() {
        List<String> list;

        matchTextArea.setText("");
        matchTextArea.setDisable(false);

        list = strategy.allThatBeginsWith(searchTextField.getText());
        for (String s : list) {
            matchTextArea.setText(matchTextArea.getText() + "\n" + s);
        }
    }

    /**
     * Set the Strategy for the autocomplete
     */
    @FXML
    public void setArrayIndex() {
        try {
            strategy = ArrayIndex.initialize(file.getName());
            searchTextField.setDisable(false);
        } catch (FileNotFoundException e){
            System.out.println("Err");
        }
    }

    /**
     * Set the Strategy for the autocomplete
     */
    @FXML
    public void setArrayForEach() {
        try {
            strategy = ArrayForEach.initialize(file.getName());
            searchTextField.setDisable(false);
        } catch (FileNotFoundException e){
            System.out.println("Err");
        }
    }

    /**
     * Set the Strategy for the autocomplete
     */
    @FXML
    public void setLinkedIndex() {
        try {
            strategy = LinkedIndex.initialize(file.getName());
            searchTextField.setDisable(false);
        } catch (FileNotFoundException e){
            System.out.println("Err");
        }
    }

    /**
     * Set the Strategy for the autocomplete
     */
    @FXML
    public void setLinkedForEach() {
        try {
            strategy = LinkedForEach.initialize(file.getName());
            searchTextField.setDisable(false);
        } catch (FileNotFoundException e){
            System.out.println("Err");
        }
    }
}
