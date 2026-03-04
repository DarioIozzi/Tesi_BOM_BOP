package Knowledge;

import java.util.ArrayList;
import java.util.List;

public class ResourceType {

    private static int counter = 0;
    private final int id;
    private String family;
    private List<FeatureType> featureTypes = new ArrayList<>();

    public ResourceType(String family, List<FeatureType> featureTypes) {
        this.family = family;
        if(featureTypes != null)
            this.featureTypes = new ArrayList<>(featureTypes);
        id = counter++;
    }

    public ResourceType(String family) {
        this.family = family;
        id = counter++;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
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
}
