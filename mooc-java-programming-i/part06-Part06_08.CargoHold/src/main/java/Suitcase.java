
import java.util.ArrayList;

public class Suitcase {

    private ArrayList<Item> items;
    private int maxWeight;

    public Suitcase(int maxWeight) {
        this.items = new ArrayList<>();
        this.maxWeight = maxWeight;
    }

    public void addItem(Item item) {
        if (this.totalWeight() + item.getWeight() > this.maxWeight) {
            return;
        }
        this.items.add(item);
    }

    public String toString() {
        if (this.items.isEmpty()) {
            return "no items (0 kg)";
        }

        String count;
        if (this.items.size() == 1) {
            count = this.items.size() + " item";
        } else {
            count = this.items.size() + " items";
        }

        return count + " (" + this.totalWeight() + " kg)";
    }

    public void printItems() {
        for (Item item : this.items) {
            System.out.println(item);
        }
    }

    public int totalWeight() {
        int sum = 0;
        for (Item item : this.items) {
            sum = sum + item.getWeight();
        }
        return sum;
    }

    public Item heaviestItem() {
        if (this.items.isEmpty()) {
            return null;
        }
        
        Item heaviest = this.items.get(0);
        for (Item item : this.items) {
            if (heaviest.getWeight() < item.getWeight()) {
                heaviest = item;
            }
        }
        return heaviest;
    }
}
