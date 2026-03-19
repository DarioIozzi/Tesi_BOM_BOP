package Operational.OrderManager;

import Operational.IntProductData;
import Operational.Process;
import Operational.Product;

import java.util.ArrayList;
import java.util.List;

public class Order {

    public enum Status{
        READY,
        IN_PROGRESS,
        COMPLETE,
        FAILED
    }

    private Status status;
    private static int counter = 0;
    private final int id;
    private final List<IntProductData> productslist;

     public Order(List<IntProductData> productslist) {

         if (productslist == null) {
             throw new NullPointerException("productslist is null");
         }

         this.id = counter++;
         this.productslist = new ArrayList<>(productslist);
         this.status = Status.READY;
     }

    public void addProduct(IntProductData ipd) {
         productslist.add(ipd);
    }

    public List<IntProductData> getProductslist() {
         return productslist;
    }

    public Product getProduct(int id){
         for (IntProductData ipd : productslist) {
             if (ipd.getProduct().getId() == id){
                 return ipd.getProduct();
             }
         }
         return null;
    }

    public Product getProduct(String code){
        for (IntProductData ipd : productslist) {
            if (ipd.getProduct().getType().getCode().equals(code)){
                return ipd.getProduct();
            }
        }
        return null;
    }

    public int getId() {
         return id;
    }

    public void removeProduct(IntProductData ipd) {
         productslist.remove(ipd);
    }

    public void start(){
         for (IntProductData ipd : productslist) {
             ipd.getProduct().getProcess().start();
         }

         this.status = Status.IN_PROGRESS;
    }

    public void complete(){
         for (IntProductData ipd : productslist) {
             ipd.getProduct().getProcess().completed();
         }

         this.status = Status.COMPLETE;
    }

    public void failed(){
         for (IntProductData ipd : productslist) {
             if(ipd.getProduct().getProcess().getStatus() != Process.Status.COMPLETE) {
                 ipd.getProduct().getProcess().failed();
             }
         }

         this.status = Status.FAILED;
    }

    public Status getStatus() {
         return status;
    }

    @Override
    public String toString(){
        return "[id = " + id + ", status = " + status + "] \n";
    }
}
