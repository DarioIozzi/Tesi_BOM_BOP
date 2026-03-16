package Operational;

import Knowledge.ProductType;

import java.util.List;

public class Element extends Product{

    private Resource resource;

    public Element(ProductType type, Process process) {
        super(process, type);
    }

    public Element(){
        super();
    }

    @Override
    public List<IntProductData> getChildren() {
        throw new UnsupportedOperationException("Not a composite.");
    }

    @Override
    public void addProduct(IntProductData pt){
        throw new UnsupportedOperationException("Not a composite.");
    }

    @Override
    public boolean removeProduct(int i, int q){
        throw new UnsupportedOperationException("Not a composite.");
    }

    @Override
    public IntProductData getChild(int i){
        throw new UnsupportedOperationException("Not a composite.");
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
