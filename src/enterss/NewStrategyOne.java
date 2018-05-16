/*
 * CS2852 – 031
 * Spring 2017
 * Lab 4 - Autocomplete
 * Name: Stuart Enters
 * Created: 3/28/2018
 */

package enterss;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Strategy for autocompleter using a Map
 */
@SuppressWarnings("unchecked")
public class NewStrategyOne implements AutoCompleter {
    private long time;
    private HashMap<Integer, ArrayList> map;

    private NewStrategyOne(ArrayList<String> list) {
        HashMap<Integer, ArrayList> map = new HashMap<>();
        for (String s: list) {
            map.computeIfAbsent((int) s.charAt(0), k -> new ArrayList());
            map.get((int) s.charAt(0)).add(s);
        }
        this.map = map;
    }

    /**
     * Method for initializing the strategy based on a dictionary file
     * @param filename the dictionary file to be read from
     * @return the new NewStrategyOne
     */
    public static AutoCompleter initialize(String filename){
        ArrayList<String> list = new ArrayList<>();
        AutoCompleter.readFile(filename, list);
        return new NewStrategyOne(list);
    }

    /**
     * Method for finding all the strings that begin with a specific prefix
     * @param prefix the prefix to compare against
     * @return a list of everything that begins with the specific prefix
     */
    @Override
    public List<String> allThatBeginsWith(String prefix) {
        if (prefix.equals("")){
            return new ArrayList<>();
        }
        time = System.nanoTime();
        ArrayList<String> list= map.get((int) prefix.charAt(0));
        list.removeIf(s -> !s.startsWith(prefix));
        time = System.nanoTime() - time;
        return list;
    }

    @Override
    public long getLastOperationTime() {
        return time;
    }
}
