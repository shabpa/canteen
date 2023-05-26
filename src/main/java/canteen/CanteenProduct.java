package canteen;

import java.util.Objects;

public abstract class CanteenProduct {
    
    private String name;
    private CanteenProduct baseProduct;

    public CanteenProduct(String name, CanteenProduct baseProduct){
        
        if (name == null)
            throw new IllegalArgumentException("Name can't be null");

        if (name.strip().length() < 4)
            throw new IllegalArgumentException("Name must be atleast 3 characters long.");

        this.name = name.strip();
        this.baseProduct = baseProduct;
    }

    public CanteenProduct(String name){
        this(name, null);
    }

    // Getter
    public String getName() {
        return name;
    }

    public CanteenProduct getBaseProduct() {
        return baseProduct;
    }

    public abstract double getPrice();


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((baseProduct == null) ? 0 : baseProduct.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CanteenProduct other = (CanteenProduct) obj;
        if (!Objects.equals(name, other.name))
            return false;
        if (!Objects.equals(baseProduct, other.baseProduct))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CanteenProduct [name=" + name + ", baseProduct=" + baseProduct + "]";
    }
    

}
