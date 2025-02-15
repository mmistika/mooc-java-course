
public class Main {

    public static void main(String[] args) {
        // Test your app here
        Warehouse w = new Warehouse();
        w.addProduct("milk", 3, 10);
        w.addProduct("coffee", 5, 7);
        w.price("milk");
    }
}
