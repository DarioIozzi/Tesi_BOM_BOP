package Knowledge;

import java.util.ArrayList;
import java.util.List;

public class ProcessType {

    private static int counter = 0;
    private final int id;
    private String family;
    private final List<FeatureType> featureTypes;
    private final List<ProductType> productTypes;

    public ProcessType(String family, List<FeatureType> ft ,List<ProductType> pts) {
        this.id = counter++;
        this.family = family;
        this.featureTypes = new ArrayList<>(ft);
        this.productTypes = new ArrayList<>(pts);
    }

    public int getId() {
        return id;
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

    public void addFeatureType(FeatureType featureType) {
        featureTypes.add(featureType);
    }

    public List<FeatureType> getFeatureTypes() {
        return featureTypes;
    }
}
