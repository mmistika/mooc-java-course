
import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {

    private ArrayList<Item> items;
    private int capacity;

    public BoxWithMaxWeight(int capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    @Override
    public void add(Item item) {
        int total = 0;
        for (Item elem : this.items) {
            total += elem.getWeight();
        }
        if (total + item.getWeight() <= this.capacity) {
            this.items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return this.items.contains(item);
    }
}
