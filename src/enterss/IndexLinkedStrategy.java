/*
 * CS2852 – 031
 * Spring 2017
 * Lab 4 - Autocomplete
 * Name: Stuart Enters
 * Created: 3/28/2018
 */

package enterss;

import java.util.LinkedList;

/**
 * Logic for auto completing using a Linked List and an index
 */
public class IndexLinkedStrategy implements AutoCompleter {
    private LinkedList<String> list;
    private long time;

    private IndexLinkedStrategy(LinkedList<String> list){
        this.list = list;
    }

    /**
     * Method for initializing AutoCompleter with a Linked List
     * @param filename the name of the dictionary to initialize
     * @return a new instance of AutoCompleter
     */
    public static AutoCompleter initialize(String filename) {
        LinkedList<String> list = new LinkedList<>();
        AutoCompleter.readFile(filename, list);
        return new IndexLinkedStrategy(list);
    }

    /**
     * Method for finding all the words that begin with a prefix
     * @param prefix the prefix to match against
     * @return a list of matching words
     */
    public LinkedList<String> allThatBeginsWith(String prefix) {
        time = System.nanoTime();
        LinkedList<String> buffer = new LinkedList<>();
        if (prefix.equals("")){
            return buffer;
        }
        String temp;
        for (int i = 0; i < list.size(); i++){
            temp = list.get(i);
            if (temp.startsWith(prefix)){
                buffer.add(temp);
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
