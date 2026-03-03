package ConfigurationJSON;

import Knowledge.FeatureType;

import java.util.ArrayList;
import java.util.List;

public class ProductTypeDTO {

    private List<FeatureTypeDTO> featureTypes;
    private String family;

    public ProductTypeDTO() {}

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public List<FeatureTypeDTO> getFeatureTypes() {
        return featureTypes;
    }

    public void setFeatureTypes(List<FeatureTypeDTO> featureTypes) {
        this.featureTypes = new ArrayList<>(featureTypes);
    }
}
