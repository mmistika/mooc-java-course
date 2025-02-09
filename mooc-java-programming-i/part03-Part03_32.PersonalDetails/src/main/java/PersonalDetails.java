
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double yearsSum = 0;
        int yearsCount = 0;
        String longestName = "";
        
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }
            
            String[] parts = input.split(",");
            String name = parts[0];
            int year = Integer.valueOf(parts[1]);
            
            yearsSum = yearsSum + year;
            ++yearsCount;
            
            if (longestName.length() < name.length()) {
                longestName = name;
            }
        }
        
        System.out.println("Longest name: " + longestName);
        System.out.println("Average of the birth years: " + (yearsSum / yearsCount));
    }
}
