package Operational;

import Knowledge.ProductType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Product {

    ProductType type;
    static int counter = 0;
    int id;
    Process process;
    List<Feature> features;

    public Product(Process process, ProductType type, List<Feature> f) {

        features = new ArrayList<>(Objects.requireNonNull(f, "features cannot be null"));
        this.process = process;
        this.id = counter++;
        this.type = type;
    }

    public void addProduct(Product p){
        throw new UnsupportedOperationException("Not a composite.");
    }

    public boolean removeProduct(int id){
        throw new UnsupportedOperationException("Not a composite.");
    }

    public Product getChild(int id){
        return null;
    }

    public List<Product> getChildren(){
        return null;
    }

    public abstract int getId();
}
