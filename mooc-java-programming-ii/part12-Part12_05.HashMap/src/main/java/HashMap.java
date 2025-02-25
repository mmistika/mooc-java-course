
import java.util.ArrayList;
import java.util.List;

public class HashMap<K, V> {

    private List<List<Pair<K, V>>> values;
    private int totalEntryCount;

    public HashMap() {
        this.values = new ArrayList<>(32);
        this.totalEntryCount = 0;
    }

    public V get(K key) {
        int hash = Math.abs(key.hashCode() % this.values.size());
        if (this.values.get(hash) == null) {
            return null;
        }

        List<Pair<K, V>> values = this.values.get(hash);

        for (int i = 0; i < values.size(); ++i) {
            if (values.get(i).getKey().equals(key)) {
                return values.get(i).getValue();
            }
        }

        return null;
    }

    public void add(K key, V value) {
        List<Pair<K, V>> valuesAtKey = this.getListByKey(key);
        int index = this.getIndexOfKey(valuesAtKey, key);

        if (index < 0) {
            valuesAtKey.add(new Pair<>(key, value));
            ++this.totalEntryCount;
        } else {
            valuesAtKey.get(index).setValue(value);
        }

        if (1.0 * this.totalEntryCount / this.values.size() > 0.75) {
            this.grow();
        }
    }

    public V remove(K key) {
        List<Pair<K, V>> valuesAtKey = this.getListByKey(key);
        if (valuesAtKey.isEmpty()) {
            return null;
        }

        int index = this.getIndexOfKey(valuesAtKey, key);
        if (index < 0) {
            return null;
        }

        return valuesAtKey.remove(index).getValue();
    }

    private List<Pair<K, V>> getListByKey(K key) {
        int hash = Math.abs(key.hashCode() % this.values.size());
        if (this.values.get(hash) == null) {
            this.values.set(hash, new ArrayList<>());
        }
        return values.get(hash);
    }

    private int getIndexOfKey(List<Pair<K, V>> list, K key) {
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private void grow() {
        List<List<Pair<K, V>>> arr = new ArrayList<>(this.values.size() * 2);
        for (int i = 0; i < this.values.size(); ++i) {
            this.copy(arr, i);
        }
        this.values = arr;
    }

    private void copy(List<List<Pair<K, V>>> arr, int from) {
        for (int i = 0; i < this.values.get(from).size(); ++i) {
            Pair<K, V> pair = this.values.get(from).get(i);

            int hash = Math.abs(pair.getKey().hashCode() % arr.size());
            if (arr.get(hash) == null) {
                arr.set(hash, new ArrayList<>());
            }

            arr.get(hash).add(pair);
        }
    }
}
