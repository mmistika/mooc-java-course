
import java.util.Scanner;

public class UserInterface {

    private Scanner scan;
    private Statistics stat;

    public UserInterface(Scanner scan, Statistics stat) {
        this.scan = scan;
        this.stat = stat;
    }
    
    public void start() {
        System.out.println("Enter point totals, -1 stops:");
        
        while (true) {
            int value = Integer.valueOf(scan.nextLine());
            if (value == -1) {
                break;
            }
            
            stat.add(value);
        }
        
        System.out.println("Point average (all): " + stat.average());
        
        System.out.print("Point average (passing): ");
        double passingAvg = stat.averagePassing();
        if (passingAvg < 0) {
            System.out.println("-");
        } else {
            System.out.println(passingAvg);
        }
        
        System.out.println("Pass percentage: " + stat.passPercentage());
        
        System.out.println("Grade distribution:");
        stat.printDistribution();
    }
}
