/*
 * CS2852 – 031
 * Spring 2017
 * Lab 4 - Autocomplete
 * Name: Stuart Enters
 * Created: 3/28/2018
 */

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * The controller for the autocomplete application
 */
public class Controller {
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
     * Method for checking if the enter key was pressed
     * @param keyEvent the keyEvent to check
     */
    @FXML public void checkEnter(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            //TODO
            System.out.println("Enter Pressed");
        }
    }

    /**
     * Set the Strategy for the autocomplete
     */
    @FXML public void setArrayIndex() {

    }
    /**
     * Set the Strategy for the autocomplete
     */
    @FXML public void setArrayForEach() {

    }
    /**
     * Set the Strategy for the autocomplete
     */
    @FXML public void setLinkedIndex() {

    }
    /**
     * Set the Strategy for the autocomplete
     */
    @FXML public void setLinkedForEach() {

    }
}
