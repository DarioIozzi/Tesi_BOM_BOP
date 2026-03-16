package Operational;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private static int counter = 0;
    private final int id;
    private final List<IntProductData> productslist;

     public Order(List<IntProductData> productslist) {

         if (productslist == null) {
             throw new NullPointerException("productslist is null");
         }

         this.id = counter++;
         this.productslist = new ArrayList<>(productslist);
     }

    public void addProduct(IntProductData ipd) {
         productslist.add(ipd);
    }

    public List<IntProductData> getProductslist() {
         return productslist;
    }

    public int getId() {
         return id;
    }

    public void removeProduct(IntProductData ipd) {
         productslist.remove(ipd);
    }
}
