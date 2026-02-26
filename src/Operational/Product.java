package Operational;

import Knowledge.ProductType;

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

    public abstract int getId();
}
