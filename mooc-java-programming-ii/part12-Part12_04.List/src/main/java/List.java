
import java.util.Arrays;

public class List<T> {

    private T[] arr;
    private int firstFreeIndex;

    public List() {
        this.arr = (T[]) new Object[10];
        this.firstFreeIndex = 0;
    }

    public void add(T value) {
        if (this.firstFreeIndex > this.arr.length) {
            this.grow();
        }
        this.arr[this.firstFreeIndex++] = value;
    }

    public int indexOfValue(T value) {
        for (int i = 0; i < this.firstFreeIndex; ++i) {
            if (this.arr[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T value) {
        return this.indexOfValue(value) >= 0;
    }

    public void remove(T value) {
        int found = this.indexOfValue(value);
        if (found < 0) {
            return;
        }
        this.moveToTheLeft(found);
        --this.firstFreeIndex;
    }
    
    public T value(int index) throws IndexOutOfBoundsException {
        if (index >= this.firstFreeIndex) {
            index = -1;
        }
        return this.arr[index];
    }
    
    public int size() {
        return this.firstFreeIndex;
    }

    private void grow() {
        this.arr = Arrays.copyOf(this.arr, this.arr.length + this.arr.length / 2);
    }

    private void moveToTheLeft(int fromIndex) {
        for (int i = fromIndex; i < this.firstFreeIndex - 1; ++i) {
            this.arr[i] = this.arr[i + 1];
        }
    }
}
