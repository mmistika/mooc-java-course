
import java.util.ArrayList;

public class ChangeHistory {
    private ArrayList<Double> history;
    
    public ChangeHistory() {
        this.history = new ArrayList<>();
    }
    
    public void add(double status) {
        this.history.add(status);
    }
    
    public void clear() {
        this.history.clear();
    }
    
    @Override
    public String toString() {
        return this.history.toString();
    }
    
    public double maxValue() {
        if (this.history.isEmpty()) {
            return 0.0;
        }
        
        double max = this.history.get(0);
        for (double entry : this.history) {
            if (max < entry) {
                max = entry;
            }
        }
        return max;
    }
    
    public double minValue() {
        if (this.history.isEmpty()) {
            return 0.0;
        }
        
        double min = this.history.get(0);
        for (double entry : this.history) {
            if (min > entry) {
                min = entry;
            }
        }
        return min;
    }
    
    public double average() {
        double sum = 0.0;
        if (this.history.isEmpty()) {
            return sum;
        }
        
        for (double entry : this.history) {
            sum += entry;
        }
        return sum / this.history.size();
    }
}
