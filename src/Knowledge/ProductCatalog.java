package Knowledge;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ProductCatalog {

    private List<ProductType> products;

    public ProductCatalog() {}

    public void addProductType(ProductType p) {

        products.add(Objects.requireNonNull(p, "Product type cannot be null"));
    }

    public List<ProductType> getProducts() {
        return products;
    }

    public ProductType getProductType(int id) {
        for (ProductType p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean removeProductType(int id) {

        Iterator<ProductType> it = products.iterator();

        while (it.hasNext()){
            ProductType p = it.next();
            if (p.getId() == id){
                it.remove();
                return true;
            }
        }
        return false;
    }
}
