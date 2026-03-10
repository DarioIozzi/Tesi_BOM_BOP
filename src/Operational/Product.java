package Operational;

import Knowledge.ProductType;

import java.util.ArrayList;
import java.util.List;

public abstract class Product {

    ProductType type;
    static int counter = 0;
    int id;
    Process process;
    List<Feature> features;

    public Product(Process process, ProductType type, List<Feature> f) {

        if(f == null)
            throw new NullPointerException("Null feature list");

        this.process = process;
        this.id = counter++;
        this.type = type;
        features = new ArrayList<>(f);
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
