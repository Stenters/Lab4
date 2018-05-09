package enterss;

import java.util.List;
import java.util.Map;

public class MapStrategy implements AutoCompleter {
    private long time;
    private Map map;

    public static AutoCompleter initialize(String filename){

    }

    @Override
    public List<String> allThatBeginsWith(String prefix) {
        return null;
    }

    @Override
    public long getLastOperationTime() {
        return time;
    }
}
