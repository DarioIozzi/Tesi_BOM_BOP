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
    private Process process;

    private final List<Feature> features;

    public Resource(int lotto, ResourceType type, List<Feature> f, Process p) {

        features = new ArrayList<>(Objects.requireNonNull(f, "features cannot be null"));
        this.id = counter++;
        this.lotto = lotto;
        this.type = type;
        this.process = p;
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

    public void typeCheck(){
        for(Feature feature : features){
            if(!type.isThere(feature.getType())){
                removeFeature(feature.getId());
            }
        }
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
