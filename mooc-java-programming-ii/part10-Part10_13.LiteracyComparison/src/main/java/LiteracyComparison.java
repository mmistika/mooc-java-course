
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {

    public static void main(String[] args) {
        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(LiteracyComparison::parseEntry)
                    .sorted()
                    .forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static LiteracyEntry parseEntry(String line) {
        String[] parts = line.trim().split(",");

        String theme = parts[0].trim();
        String age = parts[1].trim();
        String gender = parts[2].trim().split(" ")[0];
        String country = parts[3].trim();
        int year = Integer.valueOf(parts[4].trim());
        double literacyPercent = Double.valueOf(parts[5].trim());

        return new LiteracyEntry(theme, age, gender, country, year, literacyPercent);
    }
}
