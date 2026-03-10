package Operational;

import Knowledge.ProductType;

import java.util.List;

public class Element extends Product{

    public Element(ProductType type, Process process, List<Feature> f) {
        super(process, type, f);
    }

    @Override
    public List<Product> getChildren() {
        throw new UnsupportedOperationException("Not a composite.");
    }

    @Override
    public int getId() {
        return id;
    }

    public ProductType getType() {
        return type;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public void addFeature(Feature feature) {
        features.add(feature);
    }

    public List<Feature> getFeatures() {
        typeCheck();
        return features;
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

    public void typeCheck() {

        features.removeIf(feature -> !type.isThere(feature.getType()));
    }
}
