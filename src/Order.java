import Operational.Product;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private static int counter = 0;
    private final int id;
    private List<Product> productslist = new ArrayList<>();

     public Order() {
         this.id = counter++;
     }

    public void addProduct(Product p) {
         productslist.add(p);
    }

    public List<Product> getProductslist() {
         return productslist;
    }

    public int getId() {
         return id;
    }

    public void removeProduct(Product p) {
         productslist.remove(p);
    }
}
