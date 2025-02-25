
import java.util.Arrays;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // test your method here
    }

    public static int sum(int[] array, int fromWhere, int toWhere, int smallest, int largest) {
        fromWhere = Math.max(fromWhere, 0);
        toWhere = Math.min(toWhere, array.length);

        return Arrays.stream(array, fromWhere, toWhere)
                .filter(num -> smallest <= num && num <= largest)
                .sum();
    }
}
