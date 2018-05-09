package enterss;


import java.util.List;

public class TreeStrategy implements AutoCompleter {
    private long time;

    public static AutoCompleter initialize(String filename){

        return new TreeStrategy();
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
