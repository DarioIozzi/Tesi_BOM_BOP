package Knowledge;

import Operational.Product;

import java.util.ArrayList;
import java.util.List;

public class ProcessType {

    private int id;
    private String family;
    private List<ProductType> productTypes = new ArrayList<>();

    public ProcessType(int id, String family) {
        this.id = id;
        this.family = family;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void addProductType(ProductType productType) {
        productTypes.add(productType);
    }

    public List<ProductType> getProductTypes() {
        return productTypes;
    }

    public boolean removeProductType(int i) {
        for (ProductType productType : productTypes) {
            if (productType.getId() == i) {
                return productTypes.remove(productType);
            }
        }
        return false;
    }
}
