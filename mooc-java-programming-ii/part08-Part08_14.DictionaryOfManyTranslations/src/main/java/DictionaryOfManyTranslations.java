
import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryOfManyTranslations {

    private HashMap<String, ArrayList<String>> dict;

    public DictionaryOfManyTranslations() {
        this.dict = new HashMap<>();
    }

    public void add(String word, String translation) {
        ArrayList<String> translations;
        if (this.dict.containsKey(word)) {
            translations = this.dict.get(word);
        } else {
            translations = new ArrayList<>();
        }
        translations.add(translation);
        this.dict.put(word, translations);
    }

    public ArrayList<String> translate(String word) {
        ArrayList<String> translations = this.dict.get(word);
        if (translations == null) {
            translations = new ArrayList<>();
        }
        return translations;
    }
    
    public void remove(String word) {
        this.dict.remove(word);
    }
}
