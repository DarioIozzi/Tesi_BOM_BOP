package Operational;

import Knowledge.ResourceType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Resource {

    private static int counter = 0;
    private final int id;
    private int lotto;
    private ResourceType type;

    private final List<Feature> features = new ArrayList<>();

    public Resource(int lotto, ResourceType type) {

        this.id = counter++;
        this.lotto = lotto;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public int getLotto() {
        return lotto;
    }

    public void setLotto(int lotto) {
        this.lotto = lotto;
    }

    public String getFamily(){
        return type.getFamily();
    }

    public ResourceType getType(){
        return this.type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public boolean addFeature(Feature feature){
        if (type.isThere(feature.getType()))
            return features.add(feature);
        return false;
    }

    public boolean removeFeature(int i){
        for(Feature feature : features){
            if(feature.getId() == i){
                return features.remove(feature);
            }
        }
        return false;
    }
}
