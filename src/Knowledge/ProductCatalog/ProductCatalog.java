package Knowledge.ProductCatalog;

import Knowledge.ProductType;

import java.util.*;

public class ProductCatalog {

    private final Map<Integer, ProductType> products = new TreeMap<>();

    public ProductCatalog() {}

    public void addProductType(List<ProductType> productsList) {

        Map<Integer, ProductType> mp = new HashMap<>();
        for (ProductType p : productsList) {
            mp.put(p.getId(), p);
        }
        this.products.putAll(Objects.requireNonNull(mp, "Product type list cannot be null"));
    }

    public void addProductType(ProductType p) {

        products.put(Objects.requireNonNull(p, "Product type cannot be null").getId(), p);
    }

    public Collection<ProductType> getProductTypes() {
        return products.values();
    }

    public ProductType getProductType(int id) {
        return products.get(id);
    }

    public void removeProductType(int id) {

        if (id < 0)
            throw new IllegalArgumentException("Product type id cannot be negative");
        products.remove(id);
    }
}
