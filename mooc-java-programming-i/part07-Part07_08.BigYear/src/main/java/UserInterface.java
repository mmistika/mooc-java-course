
import java.util.Scanner;

public class UserInterface {

    private Scanner scan;
    private Database db;

    public UserInterface(Scanner scan, Database db) {
        this.scan = scan;
        this.db = db;
    }

    public void start() {
        while (true) {
            System.out.print("? ");
            String cmd = scan.nextLine();

            if (cmd.equals("Quit")) {
                break;

            } else if (cmd.equals("Add")) {
                System.out.print("Name: ");
                String name = scan.nextLine();
                System.out.print("Name in Latin: ");
                String lName = scan.nextLine();
                this.db.add(name, lName);
            
            } else if (cmd.equals("Observation")) {
                System.out.print("Bird? ");
                String name = scan.nextLine();
                if (!this.db.observe(name)) {
                    System.out.println("Not a bird!");
                }
                
            } else if (cmd.equals("All")) {
                this.db.printAll();
            
            } else if (cmd.equals("One")) {
                System.out.print("Bird? ");
                String name = scan.nextLine();
                this.db.printByName(name);
            }
        }
    }
}
