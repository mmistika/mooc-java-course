
import java.util.ArrayList;
import java.util.Collections;

public class Statistics {

    private ArrayList<Integer> points;
    private final static int PASS_THRESHOLD = 50;
    private final static int MAX_POINTS = 100;

    public Statistics() {
        this.points = new ArrayList<>();
    }

    public void add(int points) {
        if (0 <= points && points <= MAX_POINTS) {
            this.points.add(points);
        }
    }

    public double average() {
        int sum = 0;
        for (int point : this.points) {
            sum += point;
        }
        return (double) sum / this.points.size();
    }

    public double averagePassing() {
        int sum = 0;
        int count = 0;
        for (int point : this.points) {
            if (point >= PASS_THRESHOLD) {
                sum += point;
                ++count;
            }
        }

        if (count != 0) {
            return (double) sum / count;
        } else {
            return -1;
        }
    }

    public double passPercentage() {
        int passing = 0;
        for (int point : this.points) {
            if (point >= PASS_THRESHOLD) {
                ++passing;
            }
        }

        
        return 100.0 * passing / this.points.size();
    }

    public void printDistribution() {
        Collections.sort(this.points);
        int index = this.points.size() - 1;

        for (int i = 5; i >= 0; --i) {
            System.out.print(i + ": ");
            int gradeThreshold = PASS_THRESHOLD + 10 * (i - 1);    
            if (i == 0) {
                gradeThreshold = 0;
            }
            while (true && index >= 0) {
                if (this.points.get(index) >= gradeThreshold) {
                    System.out.print("*");
                    --index;
                } else {
                    break;
                }
            }
            System.out.println("");
        }
    }
}
