
public class LiteracyEntry implements Comparable<LiteracyEntry> {
    private String theme;
    private String age;
    private String gender;
    private String country;
    private int year;
    private double literacyPercent;

    public LiteracyEntry(String theme, String age, String gender, String country, int year, double literacyPercent) {
        this.theme = theme;
        this.age = age;
        this.gender = gender;
        this.country = country;
        this.year = year;
        this.literacyPercent = literacyPercent;
    }

    @Override
    public String toString() {
        return this.country + " (" + this.year + "), " + this.gender + ", " + this.literacyPercent;
    }

    @Override
    public int compareTo(LiteracyEntry o) {
        if (this.literacyPercent - o.literacyPercent < 0) {
            return -1;
        } else if (this.literacyPercent - o.literacyPercent > 0) {
            return 1;
        }
        return 0;
    }
}
