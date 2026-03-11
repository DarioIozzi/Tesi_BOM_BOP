package Operational;

import Knowledge.ProductType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Composite extends Product{

    private final List<Product> children;

    public Composite(Process process, ProductType ct, List<Product> children){

        super(process, ct);
        this.children = new ArrayList<>(Objects.requireNonNull(children, "children cannot be null"));
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
    public List<Product> getChildren(){
        return children;
    }
}
