/*
 * CS2852 – 031
 * Spring 2017
 * Lab 4 - Autocomplete
 * Name: Stuart Enters
 * Created: 3/28/2018
 */

package enterss;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Logic for auto completing using a Array List and a for each loop
 */
public class NewStrategyTwo implements AutoCompleter {
    private ArrayList<String> list;
    private long time;

    private NewStrategyTwo(ArrayList<String> list){
        this.list = list;
    }

    /**
     * Method for initializing AutoCompleter with a Array List
     * @param filename the name of the dictionary to initialize
     * @return a new instance of AutoCompleter
     */
    public static AutoCompleter initialize(String filename) {
        ArrayList<String> list = new ArrayList<>();
        AutoCompleter.readFile(filename, list);
        return new NewStrategyTwo(list);
    }

    /**
     * Method for finding all the words that begin with a prefix
     * @param prefix the prefix to match against
     * @return a list of matching words
     */
    public ArrayList<String> allThatBeginsWith(String prefix) {
        time = System.nanoTime();
        ArrayList<String> buffer = new ArrayList<>();
        Collections.sort(list);
        time = System.nanoTime() - time;
        return buffer;
    }

    /**
     * Getter for the time allThatBeginsWith took
     * @return the time
     */
    public long getLastOperationTime() {
        return time;
    }
}
