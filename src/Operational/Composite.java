package Operational;

import java.util.HashMap;
import java.util.Map;

public class Composite extends Product{

    private Map<Integer, Product> children = new HashMap<>();

    @Override
    public int getId(){
        throw new UnsupportedOperationException("Not an element");
    }

    @Override
    public void addProduct(Product product){
        children.put(product.getId(), product);
    }

    @Override
    public boolean removeProduct(int id){
        return children.remove(id) != null;
    }

    @Override
    public Product getChild(int id){
        return children.get(id);
    }
}
