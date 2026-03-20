package Knowledge.Catalogs;

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

    public void addProductType(List<ProductType> productsList) {

        Map<String, ProductType> mp = new HashMap<>();
        for (ProductType p : productsList) {
            mp.put(p.getCode(), p);
        }
        this.products.putAll(Objects.requireNonNull(mp, "Product type list cannot be null"));
    }

    public void addProductType(ProductType p) {

        products.put(Objects.requireNonNull(p, "Product type cannot be null").getCode(), p);
    }

    public Collection<ProductType> getProductTypes() {
        return products.values();
    }

    //TODO aggiungi in productCatalog menu
    public ProductType getProductType(String code) {
        return products.get(code);
    }

    public void removeProductType(String code) {

        products.remove(code);
    }
}
