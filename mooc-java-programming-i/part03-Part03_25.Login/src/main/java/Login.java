
import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernames = {"alex", "emma"};
        String[] passwords = {"sunshine", "haskell"};
        
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        boolean success = false;
        for (int i = 0; i < usernames.length; ++i) {
            if (usernames[i].equals(username) && passwords[i].equals(password)) {
                success = true;
                break;
            }
        }
        
        if (success) {
            System.out.println("You have successfully logged in!");
        } else {
            System.out.println("Incorrect username or password!");
        }
    }
}
