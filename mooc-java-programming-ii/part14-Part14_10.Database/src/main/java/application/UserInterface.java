package application;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            }

            // implement the functionality here
            int option;
            try {
                option = Integer.parseInt(command);
            } catch (NumberFormatException e) {
                continue;
            }
            switch (option) {
                case 1:
                    optList();
                    break;
                case 2:
                    optAdd();
                    break;
                case 3:
                    optMark();
                    break;
                case 4:
                    optRemove();
                    break;
                default:
                    break;
            }
        }

        System.out.println("Thank you!");
    }

    private void optList() throws SQLException {
        System.out.println("Listing the database contents");
        database.list().stream()
                .forEach(t -> System.out.println(t));
    }

    private void optAdd() throws SQLException {
        System.out.println("Adding a new todo");

        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter description");
        String desc = scanner.nextLine();
        database.add(new Todo(name, desc, false));
    }

    private void optMark() throws SQLException {
        System.out.println("Which todo should be marked as done (give the id)?");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return;
        }
        database.markAsDone(id);
    }

    private void optRemove() throws SQLException {
        System.out.println("Which todo should be removed (give the id)?");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return;
        }
        database.remove(id);
    }
}
