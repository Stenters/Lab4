/*
 * CS2852 – 031
 * Spring 2017
 * Lab 4 - Autocomplete
 * Name: Stuart Enters
 * Created: 3/28/2018
 */

package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Logic for auto completing using a Array List and an index
 */
public class ArrayIndex implements AutoCompleter {
    private ArrayList<String> list;

    private ArrayIndex(ArrayList<String> list){
        this.list = list;
    }

    /**
     * Method for initializing AutoCompleter with a Array List
     * @param filename the name of the dictionary to initialize
     * @return a new instance of AutoCompleter
     * @throws FileNotFoundException if file not found
     */
    public static AutoCompleter initialize(String filename) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNext()){
            String buffer = scanner.nextLine();
            list.add(buffer);
        }
        return new ArrayIndex(list);
    }

    /**
     * Method for finding all the words that begin with a prefix
     * @param prefix the prefix to match against
     * @return a list of matching words
     */
    public ArrayList<String> allThatBeginsWith(String prefix) {
        ArrayList<String> buffer = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() >= (prefix.length())){
                if (list.get(i).substring(0, (prefix.length())).equals(prefix)){
                    buffer.add(list.get(i));
                }
            }
        }
        return buffer;
    }

    @Override
    public long getLastOperationTime() {
        return 0;
    }
}
