package ConfigurationJSON;

import Knowledge.ProductType;

import java.util.ArrayList;
import java.util.List;

public class ProcessTypeDTO {

    private String family;
    private List<ProductType> productTypes;

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public List<ProductType> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(List<ProductType> productTypes) {
        this.productTypes = new ArrayList<>(productTypes);
    }
}
