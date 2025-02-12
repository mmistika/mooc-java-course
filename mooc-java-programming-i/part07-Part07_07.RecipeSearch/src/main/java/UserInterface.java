
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Scanner scan;
    private RecipeBook book;

    public UserInterface(Scanner scan, RecipeBook book) {
        this.scan = scan;
        this.book = book;
    }

    public void start() {
        System.out.print("File to read: ");
        String fileName = scan.nextLine();

        if (!this.readFile(fileName)) {
            return;
        }

        System.out.println("");
        UserInterface.printCommands();
        System.out.println("");

        while (true) {
            System.out.print("Enter command: ");
            String cmd = scan.nextLine();
            if (cmd.equals("stop")) {
                break;
            }

            System.out.println("");

            if (cmd.equals("list")) {
                book.printAll();
            
            } else if (cmd.equals("find name")) {
                System.out.print("Searched word: ");
                String word = scan.nextLine();
                book.printByKeyword(word);
            
            } else if (cmd.equals("find cooking time")) {
                System.out.print("Searched word: ");
                int time = Integer.valueOf(scan.nextLine());
                book.printByMaxTime(time);
                
            } else if (cmd.equals("find ingredient")) {
                System.out.print("Ingredient: ");
                String ingredient = scan.nextLine();
                book.printByIngredient(ingredient);
            }
        }
    }

    private boolean readFile(String fileName) {
        try (Scanner file = new Scanner(Paths.get(fileName))) {
            while (file.hasNextLine()) {
                String name = file.nextLine();
                int time = Integer.valueOf(file.nextLine());

                Recipe recipe = new Recipe(name, time);
                while (file.hasNextLine()) {
                    String ingredient = file.nextLine();
                    if (ingredient.equals("")) {
                        break;
                    }

                    recipe.addIngredient(ingredient);
                }

                this.book.add(recipe);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    private static void printCommands() {
        System.out.println("Commands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");
    }
}
