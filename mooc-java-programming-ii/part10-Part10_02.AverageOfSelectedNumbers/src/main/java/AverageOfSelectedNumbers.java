
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne
        ArrayList<String> inputs = new ArrayList<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            
            inputs.add(input);
        }
        System.out.println("");
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        boolean positive = scanner.nextLine().equals("p");
        
        double avg = inputs.stream()
                .mapToInt(s -> Integer.valueOf(s))
                .filter(num -> num > 0 == positive)
                .average()
                .getAsDouble();
        
        String optStr = positive ? "positive" : "negative";
        System.out.println("Average of the " + optStr + " numbers: " + avg);
    }
}
