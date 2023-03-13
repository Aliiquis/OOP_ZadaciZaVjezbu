package fer.oop.zzv03;

public class Main {
    public static void main(String[] args) {
        FoodType foodType = new FoodType("banana", 4, 93, 3);
        Food food = new Food(foodType, 110);
        System.out.println("protein: " + food.getProtein() + "\ncarbs: " + food.getCarbs() + "\nfat: " + food.getFat());
        FoodType banana = new FoodType("banana", 4, 93, 3);
        Food oneBanana = new Food(banana, 110);
        FoodType grapes = new FoodType("grapes", 4, 94, 2);
        Food grapeCluster = new Food(grapes, 151);
        Meal fruitSalad = new Meal(oneBanana, grapeCluster);
        fruitSalad.printIngredients();
        System.out.println("*** printing ingredients");
        for (int i = -1; i <= fruitSalad.getNumberOfIngredients(); i++) {
            System.out.println("ingredient[" + i + "] = " + fruitSalad.getIngredient(i));
        }
        System.out.println("* original meal:");
        fruitSalad.printIngredients();
        System.out.println("* new meal:");
        Meal doubleFruitSalad = new Meal(fruitSalad, 522);
        doubleFruitSalad.printIngredients();
        FoodType mlijeko = new FoodType("mlijeko", 0, 0, 0);
        FoodType palenta = new FoodType("palenta", 0, 0, 0);
        FoodType pahuljice = new FoodType("pahuljice", 0, 0, 0);
        Food pal = new Food(palenta, 200);
        Food pah = new Food(pahuljice, 100);
        Meal prvi = new Meal(new Food(mlijeko, 500), pal);
        Meal drugi = new Meal(new Food(mlijeko, 200), pah);
        System.out.printf("Similarity: %.2f%%", prvi.compare(drugi));
    }
}
