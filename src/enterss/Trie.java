/*
 * CS2852 – 031
 * Spring 2017
 * Lab 4 - Autocomplete
 * Name: Stuart Enters
 * Created: 3/28/2018
 */

package enterss;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Implementation of a Trie
 */
public class Trie {
    private TrieNode root;

    Trie(){
        root = new TrieNode(' ', null);
    }

    private class TrieNode {
        char value;
        TrieNode parent;
        boolean isLeaf = true;
        private HashMap<Character, TrieNode> children;


        TrieNode(char value, TrieNode parent){
            this.value = value;
            this.parent = parent;
            children = new HashMap<>();
        }



        TrieNode get(char c){
            for (TrieNode node :children.values()) {
                if (node.value == c){
                    return node;
                }
            }
            return null;
        }

        public boolean contains(char c) {
            return children.containsKey(c);
        }

        ArrayList<TrieNode> allLeaves() {
            ArrayList<TrieNode> leaves = new ArrayList<>();
            for (TrieNode node : children.values()) {
                if (node.isLeaf) {
                    leaves.add(node);
                } else {
                    leaves.addAll(node.allLeaves());
                }
            }
            return leaves;
        }

        @Override
        public String toString(){
            Stack<Character> wordStack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            TrieNode temp = this;

            while (temp.parent != null){
                wordStack.push(temp.value);
                temp = temp.parent;
            }

            while (!wordStack.empty()){
                sb.append(wordStack.pop());
            }
            return sb.toString();
        }
    }

    /**
     * Method for adding a word to the Trie
     * @param word the word to add
     */
    public void add(String word){
        char[] chars = word.toCharArray();
        TrieNode temp = root;

        for (char ch : chars) {
            TrieNode tempLambda = temp;
            temp.isLeaf = false;
            temp.children.computeIfAbsent(ch, (c) -> new TrieNode(ch, tempLambda));
            temp = temp.get(ch);
        }
    }

    /**
     * Method for getting all the words beginning with the prefix
     * @param prefix the word to get
     * @return all the possible words
     */
    public ArrayList<String> getWords(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode temp = root;
        ArrayList<String> words = new ArrayList<>();

        for (char c : chars) {

            if (!temp.contains(c)) {
                return new ArrayList<>();

            } else {
                temp = temp.get(c);
            }
        }
        for (TrieNode node : temp.allLeaves()) {
            words.add(node.toString());
        }
        return words;
    }
}

