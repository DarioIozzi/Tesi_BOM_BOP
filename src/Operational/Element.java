package Operational;

import Knowledge.ProductType;

import java.util.ArrayList;
import java.util.List;

public class Element extends Product{

    private static int counter = 0;
    private int id;
    private ProductType type;
    private Resource resource;

    private List<Feature> features = new ArrayList<>();

    public Element(ProductType type, Resource resource) {
        this.id = counter++;
        this.type = type;
        this.resource = resource;
    }

    @Override
    public int getId() {
        return id;
    }

    public ProductType getType() {
        return type;
    }

    public Resource getResource() {
        return resource;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public void addFeature(Feature feature) {
        features.add(feature);
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public Feature getFeature(int i) {
        for (Feature f : features) {
            if (f.getId() == i)
                return f;
        }
        return null;
    }

    public boolean removeFeature(int i) {
        for (Feature f : features) {
            if (f.getId() == i)
                return features.remove(f);
        }
        return false;
    }

    public void typeCheck(){
        for(Feature feature : features){
            if(!type.isThere(feature.getType())){
                removeFeature(feature.getId());
            }
        }
    }
}
