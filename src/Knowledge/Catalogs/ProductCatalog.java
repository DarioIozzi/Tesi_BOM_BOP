package Knowledge.Catalogs;

import Knowledge.CompositeType;
import Knowledge.RequirementType;
import Knowledge.ProductType;

import java.util.*;

public class ProductCatalog {

    private static ProductCatalog instance = null;
    private final Map<String, ProductType> finalProducts = new HashMap<>();
    private final Map<String, ProductType> allChildren = new HashMap<>();

    private ProductCatalog() {}

    public static ProductCatalog getInstance(){
        if(instance == null){
            instance = new ProductCatalog();
        }

        return instance;
    }

    public void reset(){
        finalProducts.clear();
    }

    public void addProductType(List<ProductType> productsList) {

        for (ProductType p : productsList) {
            finalProducts.put(p.getCode(), p);
            addChildren(p);
        }
    }

    public void addProductType(ProductType product) {

        finalProducts.put(product.getCode(), product);
        addChildren(product);
    }

    private void addChildren(ProductType p) {

        if (p instanceof CompositeType) {
            for (RequirementType child : p.getChildren()) {
                allChildren.put(child.getProductType().getCode(), child.getProductType());
                addChildren(child.getProductType());
            }
        }else
            allChildren.put(p.getCode(), p);
    }

    public ProductType getChild(String code) {
        return allChildren.get(code);
    }

    public Collection<ProductType> getChildren() {
        return allChildren.values();
    }

    public Collection<ProductType> getProductTypes() {
        return finalProducts.values();
    }

    public ProductType getProductType(String code) {

        ProductType p = finalProducts.get(code);
        if(p != null)
            return finalProducts.get(code);
        else
            return allChildren.get(code);
    }

    public void removeProductType(String code) {

        finalProducts.remove(code);
    }
}
