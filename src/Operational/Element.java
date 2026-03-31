package Operational;

import Knowledge.ElementType;
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
    public List<Requirement> getChildren() {
        throw new UnsupportedOperationException("Not a composite.");
    }

    @Override
    public void addProduct(Requirement pt){
        throw new UnsupportedOperationException("Not a composite.");
    }

    @Override
    public boolean removeProduct(int i, int q){
        throw new UnsupportedOperationException("Not a composite.");
    }

    @Override
    public Requirement getChild(int i){
        throw new UnsupportedOperationException("Not a composite.");
    }

    @Override
    public Resource getResource() {
        return resource;
    }

    @Override
    public void setResource(Resource resource) {
        resource.setType(((ElementType)this.getType()).getResourceType());
        this.resource = resource;
    }

    @Override
    public void removeResource(){
        this.resource = null;
    }
}
