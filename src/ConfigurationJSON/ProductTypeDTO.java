package ConfigurationJSON;

import Knowledge.FeatureType;

import java.util.List;

public class ProductTypeDTO {

    private List<FeatureType> featureTypes;
    private String family;

    public String getFamily() {
        return family;
    }

    public List<FeatureType> getFeatureTypes() {
        return featureTypes;
    }
}
