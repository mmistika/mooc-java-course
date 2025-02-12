
public class Container {

    private int value;
    private final static int MAX_VALUE = 100;

    public Container() {
        this.value = 0;
    }

    public int contains() {
        return this.value;
    }

    public void add(int amount) {
        if (amount < 0) {
            return;
        }

        this.value += amount;
        if (this.value > MAX_VALUE) {
            this.value = MAX_VALUE;
        }
    }

    public void remove(int amount) {
        if (amount < 0) {
            return;
        }

        this.value -= amount;
        if (this.value < 0) {
            this.value = 0;
        }
    }

    @Override
    public String toString() {
        return this.value + "/" + MAX_VALUE;
    }
}