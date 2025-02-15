
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BooksFromFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here

    }

    public static List<Book> readBooks(String file) {
        try {
            return Files.lines(Paths.get(file))
                    .map((String line) -> {
                        String[] parts = line.split(",");
                        String name = parts[0];
                        int year = Integer.valueOf(parts[1]);
                        int pages = Integer.valueOf(parts[2]);
                        String author = parts[3];
                        return new Book(name, year, pages, author);
                    })
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
