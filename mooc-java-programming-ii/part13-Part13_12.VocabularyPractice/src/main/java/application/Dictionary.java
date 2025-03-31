package application;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Dictionary {

    private final Map<String, String> translations;

    public Dictionary() {
        this.translations = new HashMap<>();
    }

    public String get(String word) {
        return this.translations.get(word);
    }

    public void add(String word, String translation) {
        this.translations.put(word, translation);
    }

    public String getRandomWord() {
        Random random = new Random();
        var words = translations.keySet().toArray(new String[0]);
        return words[random.nextInt(words.length)];
    }
    
    public boolean isEmpty() {
        return translations.isEmpty();
    }
}
