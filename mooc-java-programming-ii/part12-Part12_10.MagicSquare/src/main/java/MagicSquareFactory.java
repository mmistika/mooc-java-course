
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here

        int x = size / 2;
        int y = 0;

        for (int num = 1; num <= size * size; ++num) {
            square.placeValue(x, y, num);

            x = (x + 1) % size;
            y = (y - 1 + size) % size;

            if (square.readValue(x, y) != 0) {
                x = (x - 1 + size) % size;
                y = (y + 2) % size;
            }
        }

        return square;
    }

}
