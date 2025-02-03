
import java.util.Scanner;

public class Squared {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int value = Integer.valueOf(scanner.nextLine());
        
        int square = value * value;
        System.out.println(square);
    }
}
