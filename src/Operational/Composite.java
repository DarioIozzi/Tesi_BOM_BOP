package Operational;

import Knowledge.ProductType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
                                                                                //TODO chiedi per UML, aggregazione con Product o IntProductData?
public class Composite extends Product{

    private final List<IntProductData> children;

    public Composite(Process process, ProductType ct, List<IntProductData> children){

        super(process, ct);
        this.children = new ArrayList<>(Objects.requireNonNull(children, "children cannot be null"));
    }

    public Composite(){                 //Per test
        super();
        this.children = new ArrayList<>();
    }

    @Override
    public void addProduct(IntProductData pt){
        for(IntProductData child : this.children){
            if(child.getProduct().getId() == pt.getProduct().getId()){
                child.modifyQuantity(pt.getQuantity());
                return;
            }
        }
        children.add(new IntProductData(pt.getQuantity(), pt.getProduct()));
    }

    @Override
    public boolean removeProduct(int i, int q){

        Iterator<IntProductData> it = this.children.iterator();

        while (it.hasNext()) {
            IntProductData child = it.next();
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
    public List<IntProductData> getChildren(){
        return children;
    }

    @Override
    public IntProductData getChild(int i) {
        for (IntProductData child : children) {
            if(child.getProduct().getId() == i){
                return child;
            }else if(child.getProduct() instanceof Composite){
                IntProductData result = child.getProduct().getChild(i);
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
