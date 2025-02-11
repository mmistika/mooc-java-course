
import java.util.ArrayList;

public class SimpleCollection {

    private String name;
    private ArrayList<String> elements;

    public SimpleCollection(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public void add(String element) {
        this.elements.add(element);
    }

    public ArrayList<String> getElements() {
        return this.elements;
    }

    @Override
    public String toString() {
        if (elements.isEmpty()) {
            return "The collection " + this.name + " is empty.";
        }

        String status = "has " + elements.size() + " element";
        if (elements.size() == 1) {
            status = status + ":\n";
        } else {
            status = status + "s:\n";
        }

        for (String element : elements) {
            status = status + element + "\n";
        }

        return "The collection " + this.name + " " + status.trim();
    }
}
