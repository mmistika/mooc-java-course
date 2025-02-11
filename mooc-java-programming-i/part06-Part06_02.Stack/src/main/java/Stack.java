
import java.util.ArrayList;

public class Stack {
    
    ArrayList<String> strings;
    
    public Stack() {
        this.strings = new ArrayList<>();
    }
    
    public boolean isEmpty() {
        return strings.isEmpty();
    }
    
    public void add(String value) {
        strings.add(value);
    }
    
    public ArrayList<String> values() {
        return this.strings;
    }
    
    public String take() {
        int lastIndex = strings.size() - 1;
        String last = strings.get(lastIndex);
        strings.remove(lastIndex);
        return last;
    }
}
