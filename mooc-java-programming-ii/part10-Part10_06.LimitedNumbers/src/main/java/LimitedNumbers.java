
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            int num = Integer.valueOf(scanner.nextLine());
            if (num < 0) {
                break;
            }

            list.add(num);
        }

        list.stream()
                .filter(num -> 1 <= num && num <= 5)
                .forEach(System.out::println);
    }
}
