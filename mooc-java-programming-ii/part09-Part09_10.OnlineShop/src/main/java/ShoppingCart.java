
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<String, Item> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void add(String product, int price) {
        Item item = this.items.get(product);
        if (item == null) {
            this.items.put(product, new Item(product, 1, price));
        } else {
            item.increaseQuantity();
        }
    }

    public int price() {
        int total = 0;
        for (Item item : this.items.values()) {
            total += item.price();
        }
        return total;
    }
    
    public void print() {
        for (Item item : this.items.values()) {
            System.out.println(item);
        }
    }
}
