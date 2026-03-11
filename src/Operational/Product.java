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

    public abstract void addProduct(Product p);

    public abstract boolean removeProduct(int id);

    public abstract Product getChild(int id);

    public abstract List<Product> getChildren();

    public int getId(){
        return id;
    }

    public void addFeature(Feature feature) {
        features.add(feature);
    }

    public List<Feature> getFeatures() {
        typeCheck();
        return features;
    }

    public void typeCheck() {

        features.removeIf(feature -> !type.isThere(feature.getType()));
    }

    public Feature getFeature(int i) {
        for (Feature f : features) {
            if (f.getId() == i)
                return f;
        }
        return null;
    }

    public void removeFeature(int i) {
        features.removeIf(f -> f.getId() == i);
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public Process getProcess() {
        return process;
    }
}
