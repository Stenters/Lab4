/*
 * CS2852 – 031
 * Spring 2017
 * Lab 4 - Autocomplete
 * Name: Stuart Enters
 * Created: 3/28/2018
 */

package enterss;



import java.util.*;

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
        return null;
    }

    /**
     * Method for finding all the words that begin with a prefix
     * @param prefix the prefix to match against
     * @return a list of matching words
     */
    public List<String> allThatBeginsWith(String prefix) {
        if (prefix.equals("")){
            return new LinkedList<>();
        }
        time = System.nanoTime();
        time = System.nanoTime() - time;
        return new LinkedList<>();
    }

    /**
     * Getter for the time allThatBeginsWith took
     * @return the time
     */
    public long getLastOperationTime() {
        return time;
    }

    private class Trie {
        TrieNode root;

        private class TrieNode {
            char value;
            ArrayList<TrieNode> children;

            TrieNode(){
                children = new ArrayList();
            }

            TrieNode(char c){
                value = c;
                children = new ArrayList();
            }

            TrieNode get(char c){
                for (TrieNode node :children) {
                    if (node.value == c){
                        return node;
                    }
                }
                return null;
            }

        }

        public void add(char c){
            root.children.add(new TrieNode(c));
        }

        public void add(String key, char c){
            char[] chars = key.toCharArray();
            for (char ch : chars) {
                root.
            }
        }
    }
}
