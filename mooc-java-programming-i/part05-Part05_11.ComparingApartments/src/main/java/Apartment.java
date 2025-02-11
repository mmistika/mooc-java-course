
public class Apartment {

    private int rooms;
    private int squares;
    private int pricePerSquare;

    public Apartment(int rooms, int squares, int pricePerSquare) {
        this.rooms = rooms;
        this.squares = squares;
        this.pricePerSquare = pricePerSquare;
    }

    public boolean largerThan(Apartment compared) {
        return this.squares > compared.squares;
    }
    
    public int priceDifference(Apartment compared) {
        int thisPrice = this.pricePerSquare * this.squares;
        int comparedPrice = compared.pricePerSquare * compared.squares;
        return Math.abs(thisPrice - comparedPrice);
    }
    
    public boolean moreExpensiveThan(Apartment compared) {
        int thisPrice = this.pricePerSquare * this.squares;
        int comparedPrice = compared.pricePerSquare * compared.squares;
        return thisPrice - comparedPrice > 0;
    }
}
