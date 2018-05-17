/*
 * CS2852 – 031
 * Spring 2017
 * Lab 4 - Autocomplete
 * Name: Stuart Enters
 * Created: 3/28/2018
 */

package enterss;



import java.util.ArrayList;
import java.util.List;

/**
 * Logic for auto completing using a Array List and a for each loop
 */
@SuppressWarnings("unchecked")
public class NewStrategyTwo implements AutoCompleter {
    private Trie trie;
    private long time;

    private NewStrategyTwo(Trie trie){
        this.trie = trie;
    }

    /**
     * Method for initializing AutoCompleter with a Array List
     * @param filename the name of the dictionary to initialize
     * @return a new instance of AutoCompleter
     */
    public static AutoCompleter initialize(String filename) {
        ArrayList<String> list = new ArrayList<>();
        AutoCompleter.readFile(filename, list);
        Trie trie = new Trie();
        for (String s: list) {
            trie.add(s);
        }
        return new NewStrategyTwo(trie);
    }

    /**
     * Method for finding all the words that begin with a prefix
     * @param prefix the prefix to match against
     * @return a list of matching words
     */
    public List<String> allThatBeginsWith(String prefix) {
        prefix = prefix.toLowerCase();
        ArrayList<String> list = new ArrayList();
        if (prefix.equals("")){
            return list;
        }
        time = System.nanoTime();
        list.addAll(trie.getWords(prefix));
        time = System.nanoTime() - time;
        return list;
    }

    /**
     * Getter for the time allThatBeginsWith took
     * @return the time
     */
    public long getLastOperationTime() {
        return time;
    }

}
