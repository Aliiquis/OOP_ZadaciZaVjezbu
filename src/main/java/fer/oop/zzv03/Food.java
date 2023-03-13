package fer.oop.zzv03;

public class Food {
    private FoodType type;
    private int weight;

    public Food(FoodType type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public FoodType getType() {
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getProtein() {
        return weight / 100. * type.getProtein();
    }

    public double getCarbs() {
        return weight / 100. * type.getCarbs();
    }

    public double getFat() {
        return weight / 100. * type.getFat();
    }

    public String toStringInGrams() {
        return String.format("%s: p - %.1fg, c - %.1fg, f - %.1fg, w - %dg", type.getName(), getProtein(), getCarbs(), getFat(), weight);
    }

    public String toString() {
        return String.format("%s: p - %d%%, c - %d%%, f - %d%%, w - %dg", type.getName(), type.getProtein(), type.getCarbs(), type.getFat(), weight);
    }
}
