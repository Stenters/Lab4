/*
 * CS2852 – 031
 * Spring 2017
 * Lab 4 - Autocomplete
 * Name: Stuart Enters
 * Created: 3/28/2018
 */

package sample;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Interface for an autocompleter
 */
public interface AutoCompleter {

    static AutoCompleter initialize(String filename) throws FileNotFoundException{
        return null;
    }

    List<String> allThatBeginsWith(String prefix);

    long getLastOperationTime();
}
