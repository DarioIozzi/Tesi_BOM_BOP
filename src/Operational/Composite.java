package Operational;

import Knowledge.CompositeType;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Product{

    CompositeType type;
    private final List<Product> children = new ArrayList<>();

    public Composite(Process process, CompositeType ct, List<Feature> f){
        super(process, ct, f);
    }

    @Override
    public int getId(){
        return id;
    }

    @Override
    public void addProduct(Product product){
        children.add(product.getId(), product);
    }

    @Override
    public boolean removeProduct(int id){
        return children.remove(id) != null;
    }

    @Override
    public Product getChild(int id){
        for (Product child : children) {
            if (child instanceof Element) {
                if (child.getId() == id)
                    return child;
            } else if (child instanceof Composite) {
                Product res;
                for (Product c : child.getChildren()) {
                    res = c.getChild(id);
                    if (res != null) {
                        return res;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public List<Product> getChildren(){
        return children;
    }
}
