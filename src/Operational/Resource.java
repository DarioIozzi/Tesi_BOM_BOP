package Operational;

import Knowledge.ResourceType;

import java.util.ArrayList;
import java.util.List;

public class Resource {

    private final int id;
    private int lotto;
    private ResourceType type;

    private List<Feature> features = new ArrayList<Feature>();

    public Resource(int id, int lotto, ResourceType type) {
        this.id = id;
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

    public int getFamily(){
        return type.getFamily();
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public void typeCheck(){
        for(Feature feature : features){
            if(!type.isThere(feature.getType())){
                removeFeature(feature.getId());
            }
        }
    }

    public boolean addFeature(Feature feature){
        if (type.isThere(feature.type))
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
