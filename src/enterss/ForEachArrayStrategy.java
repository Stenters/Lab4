/*
 * CS2852 – 031
 * Spring 2017
 * Lab 4 - Autocomplete
 * Name: Stuart Enters
 * Created: 3/28/2018
 */

package enterss;

import java.util.ArrayList;

/**
 * Logic for auto completing using a Array List and a for each loop
 */
public class ForEachArrayStrategy implements AutoCompleter {
    private ArrayList<String> list;
    private long time;

    private ForEachArrayStrategy(ArrayList<String> list){
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
        return new ForEachArrayStrategy(list);
    }

    /**
     * Method for finding all the words that begin with a prefix
     * @param prefix the prefix to match against
     * @return a list of matching words
     */
    public ArrayList<String> allThatBeginsWith(String prefix) {
        time = System.nanoTime();
        ArrayList<String> buffer = new ArrayList<>();
        if (prefix.equals("")){
            return buffer;
        }
        for (String string : list) {
            if (string.length() >= (prefix.length())){
                if (string.startsWith(prefix)){
                    buffer.add(string);
                }
            }
        }
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
