package Knowledge;

import java.util.ArrayList;
import java.util.List;

public class ElementType extends ProductType{
    private List<FeatureType> features = new ArrayList<>();
    private final int id;
    private final String family;

    public ElementType(int id, String family) {
        this.id = id;
        this.family = family;
    }

    @Override
    public int getId(){
        return id;
    }

    public String getFamily(){
        return family;
    }

    public FeatureType getFeatureType(int id){
        for(FeatureType f : features){
            if (f.getId() == id)
                    return f;
        }
        return null;
    }

    public List<FeatureType> getFeatures(){
        return features;
    }

    public void addFeatureType(FeatureType f){
        features.add(f);
    }

    public boolean removeFeatureType(int id){
        return features.remove(id) != null;
    }
}
