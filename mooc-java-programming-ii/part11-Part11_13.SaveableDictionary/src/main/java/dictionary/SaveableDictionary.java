package dictionary;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class SaveableDictionary {

    private Map<String, String> dict;
    private String filename;

    public SaveableDictionary() {
        this.dict = new HashMap<>();
        this.filename = "";
    }

    public SaveableDictionary(String file) {
        this();
        this.filename = file;
    }

    public boolean load() {
        if (this.filename.isBlank()) {
            return false;
        }

        try (Scanner file = new Scanner(Paths.get(this.filename))) {
            while (file.hasNextLine()) {
                String[] parts = file.nextLine().split(":");

                String word = parts[0];
                String translation = parts[1];

                this.add(word, translation);
            }
            return true;
        } catch (Exception e) {
            this.dict.clear();
            return false;
        }
    }

    public boolean save() {
        if (this.filename.isBlank()) {
            return false;
        }

        try (PrintWriter file = new PrintWriter(this.filename)) {
            int count = this.dict.size();
            for (Entry<String, String> entry : this.dict.entrySet()) {
                --count;
                String entryStr = entry.getKey() + ":" + entry.getValue();
                if (count > 0) {
                    file.println(entryStr);
                } else {
                    file.print(entryStr);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void add(String words, String translation) {
        if (!this.dict.containsKey(words)) {
            this.dict.put(words, translation);
        }
    }

    public String translate(String word) {
        if (this.dict.containsKey(word)) {
            return this.dict.get(word);
        }

        for (Entry<String, String> entry : this.dict.entrySet()) {
            if (entry.getValue().equals(word)) {
                return entry.getKey();
            }
        }

        return null;
    }

    public void delete(String word) {
        if (dict.remove(word) == null) {
            String keyToRemove = null;
            for (Map.Entry<String, String> entry : dict.entrySet()) {
                if (entry.getValue().equals(word)) {
                    keyToRemove = entry.getKey();
                    break;
                }
            }
            if (keyToRemove != null) {
                dict.remove(keyToRemove);
            }
        }
    }
}
