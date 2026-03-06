import java.util.ArrayList;
import java.util.List;

public class Order {

    private static int counter = 0;
    private final int id;
    private final List<IntProductData> productslist = new ArrayList<>();        //TODO non è più corretto avere un ordine composto da type?

     public Order() {
         this.id = counter++;
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
