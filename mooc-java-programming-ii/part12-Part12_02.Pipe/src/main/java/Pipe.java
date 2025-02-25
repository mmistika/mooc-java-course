
import java.util.ArrayList;

public class Pipe<T> {

    private ArrayList<T> queue;

    public Pipe() {
        this.queue = new ArrayList<>();
    }

    public void putIntoPipe(T value) {
        this.queue.add(value);
    }

    public T takeFromPipe() {
        try {
            return this.queue.remove(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
    
    public boolean isInPipe() {
        return !this.queue.isEmpty();
    }
}
