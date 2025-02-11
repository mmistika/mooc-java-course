
import java.util.Scanner;

public class UserInterface {

    private JokeManager joke;
    private Scanner scan;

    public UserInterface(JokeManager joke, Scanner scan) {
        this.joke = joke;
        this.scan = scan;
    }

    public void start() {
        while (true) {
            System.out.println("Commands:");
            System.out.println(" 1 - add a joke");
            System.out.println(" 2 - draw a joke");
            System.out.println(" 3 - list jokes");
            System.out.println(" X - stop");
            
            String cmd = scan.nextLine();
            if (cmd.equals("X")) {
                break;
                
            } else if (cmd.equals("1")) {
                System.out.println("Write the joke to be added:");
                String joke = scan.nextLine();
                this.joke.addJoke(joke);
                
            } else if (cmd.equals("2")) {
                System.out.println("Drawing a joke.");
                System.out.println(this.joke.drawJoke());

            } else if (cmd.equals("3")) {
                System.out.println("Printing the jokes.");
                this.joke.printJokes();
            }
        }
    }
}
