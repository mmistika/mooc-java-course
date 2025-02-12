
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int first = 0;
        int second = 0;
        final int MAX_LITERS = 100;

        while (true) {
            System.out.println("First: " + first + "/" + MAX_LITERS);
            System.out.println("Second: " + second + "/" + MAX_LITERS);

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            
            String[] parts = input.split(" ");
            
            String cmd = parts[0];
            int value = Integer.valueOf(parts[1]);
            if (value < 0) {
                break;
            }
            
            if (cmd.equals("add")) {
                first += value;
                if (first > MAX_LITERS) {
                    first = MAX_LITERS;
                }
            } else if (cmd.equals("move")) {
                if (value > first) {
                    value = first;
                    first = 0;
                } else {
                    first -= value;
                }
                
                second += value;
                if (second > MAX_LITERS) {
                    second = MAX_LITERS;
                }
            } else if (cmd.equals("remove")) {
                second -= value;
                if (second < 0) {
                    second = 0;
                }
            }
        }
    }

}