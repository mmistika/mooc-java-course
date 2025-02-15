
import java.util.LinkedList;
import java.util.List;

public class Herd implements Movable {

    private List<Movable> herd;

    public Herd() {
        this.herd = new LinkedList<>();
    }

    @Override
    public String toString() {
        String result = "";
        for (Movable movable : this.herd) {
            result += movable + "\n";
        }
        return result;
    }
    
    public void addToHerd(Movable movable) {
        this.herd.add(movable);
    }
    
    @Override
    public void move(int dx, int dy) {
        for (Movable movable : this.herd) {
            movable.move(dx, dy);
        }
    }
}
