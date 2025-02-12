
import java.util.Scanner;

public class UserInterface {

    private TodoList list;
    private Scanner scan;

    public UserInterface(TodoList list, Scanner scan) {
        this.list = list;
        this.scan = scan;
    }

    public void start() {
        while (true) {
            System.out.print("Command: ");
            String cmd = this.scan.nextLine();

            if (cmd.equals("stop")) {
                break;

            } else if (cmd.equals("add")) {
                System.out.print("To add: ");
                String toAdd = this.scan.nextLine();
                this.list.add(toAdd);

            } else if (cmd.equals("list")) {
                this.list.print();

            } else if (cmd.equals("remove")) {
                System.out.print("Which one is removed? ");
                int index = Integer.valueOf(this.scan.nextLine());
                this.list.remove(index);
            }
        }
    }
}
