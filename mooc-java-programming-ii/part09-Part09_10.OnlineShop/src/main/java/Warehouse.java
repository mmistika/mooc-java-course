
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {

    private Map<String, Integer> stock;
    private Map<String, Integer> price;

    public Warehouse() {
        this.stock = new HashMap<>();
        this.price = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.stock.put(product, stock);
        this.price.put(product, price);
    }

    public int price(String product) {
        Integer value = this.price.get(product);
        if (value == null) {
            return -99;
        }
        return value;
    }

    public int stock(String product) {
        Integer value = this.stock.get(product);
        if (value == null) {
            return 0;
        }
        return value;
    }

    public boolean take(String product) {
        if (!this.stock.containsKey(product)) {
            return false;
        }

        int value = this.stock.get(product);
        if (value > 0) {
            this.stock.put(product, --value);
        }
        return value > 0;
    }
    
    public Set<String> products() {
        return this.stock.keySet();
    }
}
