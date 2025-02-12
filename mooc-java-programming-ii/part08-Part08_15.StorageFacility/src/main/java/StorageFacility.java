
import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {

    private HashMap<String, ArrayList<String>> map;

    public StorageFacility() {
        this.map = new HashMap<>();
    }

    public void add(String unit, String item) {
        ArrayList<String> items;
        if (this.map.containsKey(unit)) {
            items = this.map.get(unit);
        } else {
            items = new ArrayList<>();
        }
        items.add(item);
        this.map.put(unit, items);
    }

    public ArrayList<String> contents(String storageUnit) {
        ArrayList<String> items = this.map.get(storageUnit);
        if (items == null) {
            items = new ArrayList<>();
        }
        return items;
    }

    public void remove(String storageUnit, String item) {
        ArrayList<String> items = this.map.get(storageUnit);
        items.remove(item);

        if (items.isEmpty()) {
            this.map.remove(storageUnit);
        } else {
            this.map.put(storageUnit, items);
        }
    }
    
    public ArrayList<String> storageUnits() {
        return new ArrayList(this.map.keySet());
    }
}
