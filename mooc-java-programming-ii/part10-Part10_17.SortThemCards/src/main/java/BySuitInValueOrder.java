
import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        int bySuit = o1.getSuit().compareTo(o2.getSuit());
        if (bySuit != 0) {
            return bySuit;
        }
        return Integer.compare(o1.getValue(), o2.getValue());
    }
    
}
