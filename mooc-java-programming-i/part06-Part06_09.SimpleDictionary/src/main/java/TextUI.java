
import java.util.Scanner;

public class TextUI {

    private Scanner scan;
    private SimpleDictionary dict;

    public TextUI(Scanner scanner, SimpleDictionary dictionary) {
        this.scan = scanner;
        this.dict = dictionary;
    }

    public void start() {

        while (true) {
            System.out.print("Command: ");
            String cmd = this.scan.nextLine();

            if (cmd.equals("end")) {
                break;

            } else if (cmd.equals("add")) {
                System.out.print("Word:");
                String word = this.scan.nextLine();
                System.out.print("Translation:");
                String translation = this.scan.nextLine();
                this.dict.add(word, translation);
                
            } else if (cmd.equals("search")) {
                System.out.print("To be translated:");
                String word = this.scan.nextLine();
                String translation = this.dict.translate(word);
                
                if (translation != null) {
                    System.out.println("Translation: " + translation);
                } else {
                    System.out.println("Word " + word + " was not found");
                }
            }

            System.out.println("Unknown command");
        }

        System.out.println("Bye bye!");
    }
}
