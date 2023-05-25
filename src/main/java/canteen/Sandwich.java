package canteen;

import java.util.Arrays;

public class Sandwich extends CanteenProduct implements Ratable {

    private SandwichIngredients[] ingredients;
    int numberOfRatings;
    double productRating;


    // Constructor with name & ingredients which calls the constructor of
    // CanteenProduct
    public Sandwich(String name, SandwichIngredients... ingredients) {
        super(name);

        if (Arrays.asList(ingredients).indexOf(SandwichIngredients.BREAD) == -1
                && Arrays.asList(ingredients).indexOf(SandwichIngredients.WHOLE_GRAIN_BREAD) == -1) {

            throw new SandwichHasNoBreadException("Sandwich has no bread!");
        }

        if (ingredients.length < 2)
            throw new SandwichHasTooFewIngredientsException("Sandwich has to few ingredients!");

        this.ingredients = ingredients;

        numberOfRatings = 0;
        productRating = 0;

    }

    // Getter
    public SandwichIngredients[] getIngredients() {
        return ingredients;
    }

    @Override
    public double getPrice() {
        double sum = 0;

        // If sandwich consists of more than four ingredients we need to find the four
        // most expensive ones
        if (ingredients.length > 4) {

            // Sorting the ingredients array from low to high price
            for (int i = 0; i < ingredients.length; i++) {
                for (int j = i + 1; j < ingredients.length; j++) {

                    SandwichIngredients tmp;

                    if (ingredients[i].getPrice() > ingredients[j].getPrice()) {
                        tmp = ingredients[i];
                        ingredients[i] = ingredients[j];
                        ingredients[j] = tmp;
                    }
                }
            }

            // Getting the sum of the four most expensive ingredients
            for (int j = ingredients.length - 1; j >= ingredients.length - 4; j--)
                sum += ingredients[j].getPrice();

            return sum;
        }

        // Getting the sum of the ingredients for sandwiches that consist of less or
        // exactly 4 ingredients
        for (SandwichIngredients ingredient : this.getIngredients())
            sum += ingredient.getPrice();

        return sum;
    }

    // Returns the sum of kcal of all ingredients
    public int getKcal() {
        int sum = 0;
        for (SandwichIngredients ingredient : this.getIngredients())
            sum += ingredient.getKcal();

        return sum;
    }

    @Override
    public void rateProduct(int rating) {
        if (rating > 5 || rating < 1)
            throw new IllegalArgumentException("Rating must be 1-5!");
        productRating += rating;
        numberOfRatings++;
    }

    @Override
    public double getAvgRating() {
        return (productRating / this.getNumberOfRatings());
    }

    @Override
    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    // hashCode, equals, toString
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Arrays.hashCode(ingredients);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Sandwich other = (Sandwich) obj;
        if (!Arrays.equals(ingredients, other.ingredients))
            return false;
        return true;
    }

    public String toString() {
        return String.format("%s (%d kcal)\t\t\t\t %.2f", this.getName(), this.getKcal(), this.getPrice());
    }

}
