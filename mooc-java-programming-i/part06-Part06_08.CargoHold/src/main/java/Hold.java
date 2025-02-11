
import java.util.ArrayList;

public class Hold {

    private ArrayList<Suitcase> suitcases;
    private int maxWeight;

    public Hold(int maxWeight) {
        this.suitcases = new ArrayList<>();
        this.maxWeight = maxWeight;
    }

    public void addSuitcase(Suitcase suitcase) {
        if (this.getTotalWeight() + suitcase.totalWeight() > this.maxWeight) {
            return;
        }
        this.suitcases.add(suitcase);
    }

    public String toString() {
        return this.suitcases.size() + " suitcases (" + this.getTotalWeight() + " kg)";
    }

    private int getTotalWeight() {
        int total = 0;
        for (Suitcase suitcase : this.suitcases) {
            total = total + suitcase.totalWeight();
        }
        return total;
    }

    public void printItems() {
        for (Suitcase suitcase : this.suitcases) {
            suitcase.printItems();
        }
    }
}
