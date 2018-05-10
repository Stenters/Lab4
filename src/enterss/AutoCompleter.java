/*
 * CS2852 – 031
 * Spring 2017
 * Lab 4 - Autocomplete
 * Name: Stuart Enters
 * Created: 3/28/2018
 */

package enterss;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Interface for an autocompleter
 */
public interface AutoCompleter {

    /**
     * Method for initializing a AutoCompleter strategy
     * @param filename the name of the dictionary file
     * @return the new AutoCompleter strategy
     */
    static AutoCompleter initialize(String filename) {
        ArrayList<String> list = new ArrayList<>();
        readFile(filename, list);
        return null;
    }

    /**
     * Method for reading dictionary file into list
     * @param filename the name of the file to be read
     * @param list the list to read the dictionary to
     */
    static void readFile(String filename, List<String> list) {
        try {

            Scanner scanner = new Scanner(new File(filename));
            if (filename.substring(filename.indexOf('.'), filename.length()).equals(".csv")){
                while (scanner.hasNext()){
                    String[] buffer = scanner.nextLine().split(",");
                    list.add(buffer[1]);
                }
            } else {
                while (scanner.hasNext()){
                    String buffer = scanner.nextLine();
                    list.add(buffer);
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("Err");
        }
    }

    List<String> allThatBeginsWith(String prefix);

    long getLastOperationTime();
}
