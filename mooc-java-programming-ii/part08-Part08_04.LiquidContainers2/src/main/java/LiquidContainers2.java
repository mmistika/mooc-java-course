
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Container first = new Container();
        Container second = new Container();

        while (true) {
            System.out.println("First: " + first.toString());
            System.out.println("Second: " + second.toString());

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] parts = input.split(" ");

            String cmd = parts[0];
            int value = Integer.valueOf(parts[1]);

            if (cmd.equals("add")) {
                first.add(value);
            } else if (cmd.equals("move")) {
                int content = first.contains();
                if (value > content) {
                    value = content;
                }
                
                first.remove(value);
                second.add(value);
            } else if (cmd.equals("remove")) {
                second.remove(value);
            }
        }
    }

}