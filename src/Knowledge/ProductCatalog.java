package Knowledge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ProductCatalog {

    private final Map<Integer, ProductType> products = new HashMap<>();

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

    public Map<Integer, ProductType> getProductTypes() {
        return products;
    }

    public ProductType getProductType(int id) {
        return products.get(id);
    }

    public void removeProductType(int id) {

        products.remove(id);
    }
}
