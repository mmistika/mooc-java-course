
import java.util.ArrayList;

public class RecipeBook {

    private ArrayList<Recipe> recipes;

    public RecipeBook() {
        this.recipes = new ArrayList<>();
    }

    public void add(Recipe recipe) {
        this.recipes.add(recipe);
    }

    public void printAll() {
        this.printHeading();
        for (Recipe recipe : recipes) {
            System.out.println(recipe);
        }
    }

    public void printByKeyword(String word) {
        this.printHeading();
        for (Recipe recipe : recipes) {
            if (recipe.getName().contains(word)) {
                System.out.println(recipe);
            }
        }
    }

    public void printByMaxTime(int maxCookingTime) {
        this.printHeading();
        for (Recipe recipe : recipes) {
            if (recipe.getCookingTime() <= maxCookingTime) {
                System.out.println(recipe);
            }
        }
    }

    public void printByIngredient(String ingredient) {
        this.printHeading();
        for (Recipe recipe : recipes) {
            if (recipe.containsIngredient(ingredient)) {
                System.out.println(recipe);
            }
        }
    }

    private void printHeading() {
        System.out.println("Recipes:");
    }
}
