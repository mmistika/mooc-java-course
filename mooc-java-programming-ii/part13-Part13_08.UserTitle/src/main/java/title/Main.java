package title;

import java.util.Scanner;
import javafx.application.Application;

public class Main {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Application.launch(UserTitle.class, scan.nextLine());
    }
    
}
