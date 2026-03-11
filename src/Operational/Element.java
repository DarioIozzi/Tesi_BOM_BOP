package Operational;

import Knowledge.ProductType;

import java.util.List;

public class Element extends Product{

    private Resource resource;

    public Element(ProductType type, Process process) {
        super(process, type);
    }

    @Override
    public List<Product> getChildren() {
        throw new UnsupportedOperationException("Not a composite.");
    }

    @Override
    public void addProduct(Product p){
        throw new UnsupportedOperationException("Not a composite.");
    }

    @Override
    public boolean removeProduct(int id){
        throw new UnsupportedOperationException("Not a composite.");
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
