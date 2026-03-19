package Knowledge;

import java.util.ArrayList;
import java.util.List;

public class ResourceType {

    private static int counter = 0;
    private final int id;
    private int family;
    private List<FeatureType> featureTypes = new ArrayList<>();

    public ResourceType(int family, List<FeatureType> featureTypes) {
        if(featureTypes != null)
            this.featureTypes = new ArrayList<>(featureTypes);
        this.family = family;
        id = counter++;
    }

    public int getFamily() {
        return family;
    }

    public void setFamily(int family) {
        this.family = family;
    }

    public int getId(){
        return id;
    }

    public void addFeatureType(FeatureType featureType) {
        featureTypes.add(featureType);
    }

    public boolean isThere(FeatureType ft){
        for(FeatureType f : featureTypes){
            if(f.getId() == ft.getId())
                return true;
        }
        return false;
    }

    public boolean removeFeatureType(int id) {
        for (FeatureType featureType : featureTypes) {
            if (featureType.getId() == id) {
                return featureTypes.remove(featureType);
            }
        }
        return false;
    }

    public List<FeatureType> getFeatureTypes() {
        return featureTypes;
    }
}
