
import java.util.ArrayList;

public class Box implements Packable {

    private ArrayList<Packable> items;
    private double capacity;

    public Box(double maximumCapacity) {
        this.items = new ArrayList<>();
        this.capacity = maximumCapacity;
    }

    public void add(Packable item) {
        int total = 0;
        for (Packable elem : this.items) {
            total += elem.weight();
        }
        if (total + item.weight() <= this.capacity) {
            this.items.add(item);
        }
    }

    @Override
    public double weight() {
        double weight = 0;
        for (Packable item : this.items) {
            weight += item.weight();
        }
        return weight;
    }

    @Override
    public String toString() {
        return "Box: " + this.items.size() + " items, total weight " + this.weight() + " kg";
    }
}
