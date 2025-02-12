
import java.util.HashMap;

public class Nicknames {

    public static void main(String[] args) {
        // Do the operations required here!
        HashMap<String, String> mapping = new HashMap<>();
        mapping.put("matthew", "matt");
        mapping.put("michael", "mix");
        mapping.put("arthur", "artie");
        
        System.out.println(mapping.get("matthew"));
    }

}
