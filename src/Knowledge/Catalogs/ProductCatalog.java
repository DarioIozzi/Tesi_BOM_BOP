package Knowledge.Catalogs;

import Knowledge.CompositeType;
import Knowledge.IntProductTypeData;
import Knowledge.ProductType;

import java.util.*;

public class ProductCatalog {

    private static ProductCatalog instance = null;
    private final Map<String, ProductType> products = new HashMap<>();

    private ProductCatalog() {}

    public static ProductCatalog getInstance(){
        if(instance == null){
            instance = new ProductCatalog();
        }

        return instance;
    }

    public void reset(){
        products.clear();
    }

    public void addProductType(List<ProductType> productsList) {

        for (ProductType p : productsList) {
            addRecursively(p);
        }
    }

    public void addProductType(ProductType product) {

            addRecursively(product);
    }

    private void addRecursively(ProductType p) {

        products.put(p.getCode(), p);

        if (p instanceof CompositeType) {
            for (IntProductTypeData child : p.getChildren()) {
                addRecursively(child.getProductType());
            }
        }
    }

    public Collection<ProductType> getProductTypes() {
        return products.values();
    }

    public ProductType getProductType(String code) {
        return products.get(code);
    }

    public void removeProductType(String code) {

        products.remove(code);
    }
}
