package ConfigurationJSON;

import Knowledge.ProductType;

import java.util.List;

public class ProcessTypeDTO {

    private String family;
    private List<ProductType> productTypes;

    public String getFamily() {
        return family;
    }

    public List<ProductType> getProductTypes() {
        return productTypes;
    }
}
