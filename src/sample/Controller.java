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
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * The controller for the autocomplete application
 */
public class Controller {
    private File file = new File(
            "file:\\C:\\Users\\enterss\\Documents\\GitHub\\CS2852\\Labs\\Lab4\\2000words.txt");
    private AutoCompleter strategy = ArrayForEach.initialize(file.getName());

    //DEBUG
    private long maxTimer = 0;
    private long minTimer = Long.MAX_VALUE;

    //TODO: Exception Handling, disabling = true?, benchmarking,


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
        searchTextField.setDisable(true);
    }

    /**
     * Method for checking if the enter key was pressed
     */
    @FXML
    public void checkKey() {
        List<String> list;

        matchTextArea.setText("");

        list = strategy.allThatBeginsWith(searchTextField.getText());
        for (String s : list) {
            matchTextArea.setText(matchTextArea.getText() + "\n" + s);
        }
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

        //DEBUG:

        System.out.println("Using: " + strategy.getClass() +
                " With prefix: " + searchTextField.getText());
        System.out.println("Time: " + getSecondTime(time));

        if (time > maxTimer){
            System.err.println("Max time: " + getSecondTime(time));
            maxTimer = time;
        } else if (time < minTimer){
            System.err.println("Min time: " + getSecondTime(time));
            minTimer = time;
        }


        matchCounterLabel.setText("Matches: " + list.size());

    }

    /**
     * Set the Strategy for the autocomplete
     */
    @FXML
    public void setArrayIndex() {
        strategy = ArrayIndex.initialize(file.getName());
        searchTextField.setDisable(false);

    }

    /**
     * Set the Strategy for the autocomplete
     */
    @FXML
    public void setArrayForEach() {
        strategy = ArrayForEach.initialize(file.getName());
        searchTextField.setDisable(false);
    }

    /**
     * Set the Strategy for the autocomplete
     */
    @FXML
    public void setLinkedIndex() {
        strategy = LinkedIndex.initialize(file.getName());
        searchTextField.setDisable(false);
    }

    /**
     * Set the Strategy for the autocomplete
     */
    @FXML
    public void setLinkedForEach() {
        strategy = LinkedForEach.initialize(file.getName());
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

    //DEBUG
    private String getSecondTime(long nanos) {
        return String.format("%d.%03d,%03d,%03d\n", TimeUnit.NANOSECONDS.toSeconds(nanos),
                TimeUnit.NANOSECONDS.toMillis(nanos) % TimeUnit.SECONDS.toMillis(1),
                TimeUnit.NANOSECONDS.toMicros(nanos) % TimeUnit.MILLISECONDS.toMicros(1),
                TimeUnit.NANOSECONDS.toNanos(nanos) % TimeUnit.MICROSECONDS.toNanos(1));
    }
}
