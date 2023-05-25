package canteen;

import java.util.Arrays;

public class Coffee extends CanteenProduct {
    
    private CoffeeIngredients[] ingredients;

    public Coffee(String name, Coffee baseProduct, CoffeeIngredients...ingredients){
        super(name, baseProduct);
        if (ingredients == null || ingredients.length == 0)
            throw new IllegalArgumentException("Coffee needs atleast one additional ingredient");

        this.ingredients = ingredients;
    }

    public Coffee(String name, CoffeeIngredients...ingredients){
        this(name, null, ingredients);
    }

    public CoffeeIngredients[] getIngredients(){
        return ingredients;
    }
   
    @Override
    public double getPrice() {

        double sum = 0;
        CanteenProduct currentProduct = this;

        for (CoffeeIngredients ingredient : ((Coffee) currentProduct).getIngredients()){
            sum += ingredient.getPrice();
        }

        while (currentProduct.getBaseProduct() != null) {
            for (CoffeeIngredients ingredient : ((Coffee) currentProduct.getBaseProduct()).getIngredients()){
                sum += ingredient.getPrice();
            }
            currentProduct = currentProduct.getBaseProduct();
        }

        return sum;
        
    }

    @Override
    public boolean equals(Object obj){
        if (!super.equals(obj))
            return false;
        Coffee other = (Coffee) obj;
        if (!Arrays.equals(ingredients, other.ingredients))
            return false;
        return true;
    }

    @Override
    public String toString(){
        return String.format("%s \t\t\t\t %.2f", this.getName(), this.getPrice());
    }

}