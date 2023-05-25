package canteen;

public enum SandwichIngredients {
    BREAD(0.5, 190), WHOLE_GRAIN_BREAD(0.7, 194), SALAMI(0.5, 115), 
    HAM(0.5, 46), CHICKEN(0.5, 55), BEEF(1.0, 70),
    VEGAN_MEET_REPLACEMENT(1.0, 117), CHEDDAR(0.5, 113), MOZARELLA(0.5, 35),
    EMMENTAL(1.0, 120), CREAM_CHEESE(0.5, 100), TOMATO(0.2, 7),
    CUCUMBER(0.2, 3), PAPRIKA(0.4, 4), SALAD(0.2, 2),
    KETCHUP(0.2, 20), MAYONNAISE(0.2, 68), SPICY_JOGHURT(0.6, 15);

    private final double price;
    private final int kcal;

    private SandwichIngredients(double price, int kcal) {
        this.price = price;
        this.kcal = kcal;
    }

    public double getPrice(){
        return price;
    }

    public int getKcal(){
        return kcal;
    }

}
