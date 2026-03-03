package ConfigurationJSON;

import Knowledge.ProductType;

import java.util.ArrayList;
import java.util.List;

public class ProcessTypeDTO {

    private String family;
    private List<ProductTypeDTO> productTypes;
    private List<FeatureTypeDTO> featureTypes;

    public ProcessTypeDTO() {}

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public List<ProductTypeDTO> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(List<ProductTypeDTO> productTypes) {
        this.productTypes = new ArrayList<>(productTypes);
    }

    public List<FeatureTypeDTO> getFeatureTypes() {
        return featureTypes;
    }

    public void setFeatureTypes(List<FeatureTypeDTO> featureTypes) {
        this.featureTypes = new ArrayList<>(featureTypes);
    }
}
