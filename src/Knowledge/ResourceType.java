package Knowledge;

import java.util.ArrayList;
import java.util.List;

public class ResourceType {

    private int family;
    private final List<FeatureType> featureTypes;

    public ResourceType(int family, List<FeatureType> featureTypes) {
        this.family = family;
        this.featureTypes = new ArrayList<>(featureTypes);
    }

    public int getFamily() {
        return family;
    }

    public void setFamily(int family) {
        this.family = family;
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
}
