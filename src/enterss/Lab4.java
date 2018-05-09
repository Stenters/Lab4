/*
 * CS2852 – 031
 * Spring 2017
 * Lab 4 - Autocomplete
 * Name: Stuart Enters
 * Created: 3/28/2018
 */

package enterss;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The entry point to the application
 */
public class Lab4 extends Application {
    private static final int PREF_WIDTH = 600;
    private static final int PREF_HEIGHT = 400;

    /**
     * The start of the application
     * @param primaryStage the stage to display to
     * @throws Exception if everything goes wrong
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Lab4controller.fxml"));
        primaryStage.setTitle("Auto Complete");
        primaryStage.setScene(new Scene(root, PREF_WIDTH, PREF_HEIGHT));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}