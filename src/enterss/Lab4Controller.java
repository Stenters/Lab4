/*
 * CS2852 – 031
 * Spring 2017
 * Lab 4 - Autocomplete
 * Name: Stuart Enters
 * Created: 3/28/2018
 */

package enterss;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * The controller for the autocomplete application
 */
public class Lab4Controller {
    private File file;
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

        StringBuilder sb = new StringBuilder();
        list = strategy.allThatBeginsWith(searchTextField.getText());
        for (String s : list) {
            sb.append("\n").append(s);
        }
        matchTextArea.setText(sb.toString());

        long time = strategy.getLastOperationTime();

        if (TimeUnit.NANOSECONDS.toMicros(time) < 1){
            timeLabel.setText(getNanoTime(time));
        } else if(TimeUnit.NANOSECONDS.toMillis(time) < 1){
            timeLabel.setText(getMicroTime(time));
        } else if(TimeUnit.NANOSECONDS.toSeconds(time) < 1){
            timeLabel.setText(getMilliTime(time));
        } else {
            timeLabel.setText(getTime(strategy.getLastOperationTime()));
        }
        matchCounterLabel.setText("Matches: " + list.size());

    }

    /**
     * Set the Strategy for the autocomplete
     */
    @FXML
    public void setArrayIndex() {
        strategy = IndexArrayStrategy.initialize(file.getName());
        searchTextField.setDisable(false);

    }

    /**
     * Set the Strategy for the autocomplete
     */
    @FXML
    public void setArrayForEach() {
        strategy = ForEachArrayStrategy.initialize(file.getName());
        searchTextField.setDisable(false);
    }

    /**
     * Set the Strategy for the autocomplete
     */
    @FXML
    public void setLinkedIndex() {
        strategy = IndexLinkedStrategy.initialize(file.getName());
        searchTextField.setDisable(false);
    }

    /**
     * Set the Strategy for the autocomplete
     */
    @FXML
    public void setLinkedForEach() {
        strategy = ForEachLinkedStrategy.initialize(file.getName());
        searchTextField.setDisable(false);
    }

    public void setTree(){
        strategy = TreeStrategy.initialize(file.getName());
        searchTextField.setDisable(false);
    }

    public void setMap() {
        strategy = MapStrategy.initialize(file.getName());
        searchTextField.setDisable(false);

    }

    private String getNanoTime(long nanos){
        return TimeUnit.NANOSECONDS.toNanos(nanos) + " (ns)";
    }

    private String getMicroTime(long nanos){
        return TimeUnit.NANOSECONDS.toMicros(nanos) + " (μs)";
    }

    private String getMilliTime(long nanos){
        return TimeUnit.NANOSECONDS.toMillis(nanos) + " (ms)";
    }

    private String getTime(long nanos) {
        return String.format("%02d:%02d.%03d", TimeUnit.NANOSECONDS.toMinutes(nanos),
                TimeUnit.NANOSECONDS.toSeconds(nanos) % TimeUnit.MINUTES.toSeconds(1),
                TimeUnit.NANOSECONDS.toMillis(nanos) % TimeUnit.SECONDS.toMillis(1));

    }
}