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
import java.util.Map;

/**
 * Strategy for autocompleter using a Map
 */
@SuppressWarnings("unchecked")
public class NewStrategyOne implements AutoCompleter {
    private static final int ASCII_CHAR_START_VAL = 65;
    private static final int ASCII_CHAR_END_VAL = 91;
    private long time;
    private Map map;

    private NewStrategyOne(ArrayList<String> list) {
        Map<Character, ArrayList> map = new HashMap<>();
        for (int i = ASCII_CHAR_START_VAL; i < ASCII_CHAR_END_VAL; i++) {
            map.put((char) i, new ArrayList<String>());
        }
        for (String s: list) {
            map.get(Character.toUpperCase(s.charAt(0))).add(s);
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
        time = System.nanoTime();
        ArrayList<String> list = new ArrayList();
        ArrayList<String> tempList = (ArrayList) map.get(prefix.charAt(0));
        for (String s: tempList) {
            if (s.startsWith(prefix)){
                list.add(s);
            }
        }
        time = System.nanoTime() - time;
        return list;
    }

    @Override
    public long getLastOperationTime() {
        return time;
    }
}
