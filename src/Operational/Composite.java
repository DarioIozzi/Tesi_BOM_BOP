package Operational;

import Knowledge.ProductType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Composite extends Product{

    private final List<Requirement> children;

    public Composite(Process process, ProductType ct, List<Requirement> children){

        super(process, ct);
        this.children = new ArrayList<>(Objects.requireNonNull(children, "children cannot be null"));
    }

    public Composite(){                 //Per test
        super();
        this.children = new ArrayList<>();
    }

    @Override
    public void addProduct(Requirement pt){
        for(Requirement child : this.children){
            if(child.getProduct().getId() == pt.getProduct().getId()){
                child.modifyQuantity(pt.getQuantity());
                return;
            }
        }
        children.add(new Requirement(pt.getQuantity(), pt.getProduct()));
    }

    @Override
    public boolean removeProduct(int i, int q){

        Iterator<Requirement> it = this.children.iterator();

        while (it.hasNext()) {
            Requirement child = it.next();
            if(child.getProduct().getId() == i){
                child.modifyQuantity(-q);
                if(child.getQuantity() == 0) {
                    it.remove();
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Requirement> getChildren(){
        return children;
    }

    @Override
    public Requirement getChild(int i) {
        for (Requirement child : children) {
            if(child.getProduct().getId() == i){
                return child;
            }else if(child.getProduct() instanceof Composite){
                Requirement result = child.getProduct().getChild(i);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    @Override
    public Resource getResource(){
        throw new UnsupportedOperationException("Not an element.");
    }

    @Override
    public void setResource(Resource resource){
        throw new UnsupportedOperationException("Not an element.");
    }

    @Override
    public void removeResource(){
        throw new UnsupportedOperationException("Not an element.");
    }
}
