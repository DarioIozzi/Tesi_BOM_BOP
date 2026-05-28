package Operational.OrderManager;

import Operational.Composite;
import Operational.Requirement;
import Operational.Process;
import Operational.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

    public enum Status{
        READY,
        IN_PROGRESS,
        COMPLETE,
        FAILED
    }

    private LocalDate deadline;
    private Status status;
    private static int counter = 0;
    private final int id;
    private final List<Requirement> productslist;

     public Order(List<Requirement> productslist, LocalDate deadline) {

         if (productslist == null) {
             throw new NullPointerException("productslist is null");
         }

         this.id = counter++;
         this.productslist = new ArrayList<>(productslist);
         this.status = Status.READY;
         this.deadline = deadline;
     }

    public void addProduct(Requirement ipd) {
         productslist.add(ipd);
    }

    public List<Requirement> getProductslist() {
         return productslist;
    }

    public Product getProduct(String code) {
        for (Requirement ipd : productslist) {
            Product p = findProduct(ipd.getProduct(), code);
            if (p != null) {
                return p;
            }
        }
        return null;
    }

    private Product findProduct(Product product, String code) {
        if (product.getType().getCode().equals(code)) {
            return product;
        }

        if (product instanceof Composite) {
            Composite composite = (Composite) product;
            for (Requirement childData : composite.getChildren()) {
                Product found = findProduct(childData.getProduct(), code);
                if (found != null) {
                    return found;
                }
            }
        }

        return null;
    }

    public int getId() {
         return id;
    }

    public void removeProduct(Requirement ipd) {
         productslist.remove(ipd);
    }

    public void start(){
         for (Requirement ipd : productslist) {
             ipd.getProduct().getProcess().start();
         }

         this.status = Status.IN_PROGRESS;
    }

    public void complete(){
         for (Requirement ipd : productslist) {
             ipd.getProduct().getProcess().completed();
         }

         this.status = Status.COMPLETE;
    }

    public void failed(){
         for (Requirement ipd : productslist) {
             if(ipd.getProduct().getProcess().getStatus() != Process.Status.COMPLETE) {
                 ipd.getProduct().getProcess().failed();
             }
         }

         this.status = Status.FAILED;
    }

    public Status getStatus() {
         return status;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    @Override
    public String toString(){
        return "[id = " + id + ", status = " + status + "] \n";
    }
}
