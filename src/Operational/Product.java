package Operational;


import java.util.List;

public abstract class Product {

    public void addProduct(Product p){
        throw new UnsupportedOperationException("Not a composite.");
    }

    public boolean removeProduct(int id){
        throw new UnsupportedOperationException("Not a composite.");
    }

    public Product getChild(int id){
        return null;
    }

    public List<Product> getChildren(){
        return null;
    }

    public abstract int getId();
}
