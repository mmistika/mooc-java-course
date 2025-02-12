
import java.util.ArrayList;

public class Database {

    private ArrayList<Bird> birds;

    public Database() {
        this.birds = new ArrayList<>();
    }
    
    public void add(String name, String latinName) {
        birds.add(new Bird(name, latinName));
    }
    
    public boolean observe(String name) {
        Bird bird = getByName(name);
        if (bird != null) {
            bird.observe();
            return true;
        } else {
            return false;
        }
    }
    
    public void printAll() {
        for (Bird bird : birds) {
            System.out.println(bird);
        }
    }
    
    public void printByName(String name) {
        Bird bird = getByName(name);
        if (bird != null) {
            System.out.println(bird);
        }
    }
    
    private Bird getByName(String name) {
        for (Bird bird : birds) {
            if (bird.getName().equals(name)) {
                return bird;
            }
        }
        return null;
    }
}
