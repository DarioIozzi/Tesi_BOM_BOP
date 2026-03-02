package ConfigurationJSON;

import Knowledge.FeatureType;

import java.util.ArrayList;
import java.util.List;

public class ProductTypeDTO {

    private List<FeatureType> featureTypes;
    private String family;

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public List<FeatureType> getFeatureTypes() {
        return featureTypes;
    }

    public void setFeatureTypes(List<FeatureType> featureTypes) {
        this.featureTypes = new ArrayList<>(featureTypes);
    }
}
