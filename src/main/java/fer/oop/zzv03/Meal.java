package fer.oop.zzv03;

public class Meal {
    private Food[] ingredients;

    public Meal(Food... ingredients) {
        this.ingredients = ingredients;
    }

    public Meal(Meal meal, int weight) {
        ingredients = new Food[meal.getNumberOfIngredients()];
        int w = meal.getWeight();
        for (int i = 0; i < meal.getNumberOfIngredients(); i++) {
            this.ingredients[i] = meal.getIngredient(i);
            this.ingredients[i].setWeight(meal.getIngredient(i).getWeight() * weight / w);
        }
    }

    public double compare(Meal other) {
        for (Food i : ingredients) {
            for (Food j : other.ingredients) {
                if (i.getType() == j.getType()) {
                    return Math.min(100. * i.getWeight() / this.getWeight(), 100. * j.getWeight() / other.getWeight());
                }
            }
        }
        return 0.;
    }

    public int getWeight() {
        int sum = 0;
        for (Food ingredient : ingredients) {
            sum += ingredient.getWeight();
        }
        return sum;
    }

    public void printIngredients() {
        for (int i = 0; i < ingredients.length; i++) {
            System.out.printf("Ingredient[%d] = %s: p - %.1fg, c - %.1fg, f - %.1fg, w - %dg\n",
                    i, ingredients[i].getType().getName(), ingredients[i].getProtein(), ingredients[i].getCarbs(), ingredients[i].getFat(), ingredients[i].getWeight());
        }
    }

    public int getNumberOfIngredients() {
        return ingredients.length;
    }

    public Food getIngredient(int index) {
        if (index >= 0 && index < ingredients.length) {
            return ingredients[index];
        } else {
            return null;
        }
    }
}
