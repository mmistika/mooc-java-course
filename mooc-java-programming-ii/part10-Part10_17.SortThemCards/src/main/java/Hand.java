
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {

    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public void print() {
        this.cards.stream().forEach(System.out::println);
    }

    public void sort() {
        Collections.sort(this.cards);
    }
    
    public void sortBySuit() {
        Collections.sort(this.cards, new BySuitInValueOrder());
    }

    @Override
    public int compareTo(Hand o) {
        int thisWeight = this.cards.stream()
                .mapToInt(c -> c.getValue())
                .sum();
        
        int otherWeight = o.cards.stream()
                .mapToInt(c -> c.getValue())
                .sum();
        
        return Integer.compare(thisWeight, otherWeight);
    }
}
