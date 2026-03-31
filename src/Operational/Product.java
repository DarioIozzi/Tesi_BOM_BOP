package Operational;

import Knowledge.ProductType;

import java.util.ArrayList;
import java.util.List;

public abstract class Product {

    ProductType type;
    static int counter = 0;
    int id;
    Process process;
    List<Feature> features = new ArrayList<>();

    public Product(Process process, ProductType type) {

        this.process = process;
        this.id = counter++;
        this.type = type;
    }

    public Product(){                   //Per test
        this.id = counter++;
        this.features = new ArrayList<>();
    }

    public static void resetCounter(){              //Per test
        counter = 0;
    }

    public abstract void addProduct(Requirement pt);

    public abstract boolean removeProduct(int i, int q);

    public abstract List<Requirement> getChildren();

    public abstract Requirement getChild(int i);

    public int getId(){
        return id;
    }

    public void addFeature(Feature feature) {
        features.add(feature);
    }

    public List<Feature> getFeatures() {

        return features;
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

    @Override
    public String toString(){
        return "{id= " + id + ", family= " + type.getFamily() + "} \n";
    }

    public abstract Resource getResource();

    public abstract void setResource(Resource resource);

    public abstract void removeResource();
}
