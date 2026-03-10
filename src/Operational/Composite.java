package Operational;

import Knowledge.CompositeType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Composite extends Product{

    private final List<Product> children;

    public Composite(Process process, CompositeType ct, List<Feature> f, List<Product> children){

        super(process, ct, f);
        this.children = new ArrayList<>(Objects.requireNonNull(children, "children cannot be null"));
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
