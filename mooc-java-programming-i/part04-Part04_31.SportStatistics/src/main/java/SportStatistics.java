
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("File:");
        String fileName = scan.nextLine();

        ArrayList<String> lines = new ArrayList<>();
        try (Scanner file = new Scanner(Paths.get(fileName))) {
            while (file.hasNextLine()) {
                lines.add(file.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Team:");
        String teamName = scan.nextLine();

        int played = 0;
        int won = 0;
        int lost = 0;

        for (String line : lines) {
            String[] parts = line.split(",");
            String homeTeam = parts[0];
            String guestTeam = parts[1];
            int homeScore = Integer.valueOf(parts[2]);
            int guestScore = Integer.valueOf(parts[3]);

            if (homeTeam.equals(teamName) || guestTeam.equals(teamName)) {
                ++played;
                boolean isHome = homeTeam.equals(teamName);
                if ((isHome && homeScore > guestScore) || (!isHome && guestScore > homeScore)) {
                    won++;
                } else {
                    lost++;
                }
            }
        }
        
        System.out.println("Games: " + played);
        System.out.println("Wins: " + won);
        System.out.println("Losses: " + lost);
    }
}
