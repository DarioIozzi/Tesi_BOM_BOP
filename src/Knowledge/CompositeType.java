package Knowledge;

import java.util.*;

public class CompositeType extends ProductType{

    private final List<RequirementType> children;

    public CompositeType(ProcessType pt, String family, List<FeatureType> ft, List<RequirementType> children, String code) {

        super(pt, family, ft, code);
        this.children = new ArrayList<>(Objects.requireNonNull(children, "children cannot be null"));
        this.calculateNumberElements();
    }

    public CompositeType(){                         //Per test
        super();
        this.children = new ArrayList<>();
    }

    @Override
    public void addProductType(RequirementType pt) {

        for(RequirementType child : this.children){
            if(child.getProductType().getId() == pt.getProductType().getId()){
                child.modifyQuantity(pt.getQuantity());
                return;
            }
        }
        children.add(new RequirementType(pt.getQuantity(), pt.getProductType()));
    }

    @Override
    public boolean removeProductType(int i, int q){

        Iterator<RequirementType> it = this.children.iterator();

        while (it.hasNext()) {
            RequirementType child = it.next();
            if(child.getProductType().getId() == i){
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
    public RequirementType getChild(int i) {
        for (RequirementType child : children) {
            if(child.getProductType().getId() == i){
                return child;
            }else if(child.getProductType() instanceof CompositeType){
                RequirementType result = child.getProductType().getChild(i);
                if (result != null)
                    return result;
            }
        }
        return null;
    }

    @Override
    public List<RequirementType> getChildren(){
        return children;
    }

    @Override
    public List<RequirementType> getAllElement(){

        List<RequirementType> list = new ArrayList<>();
        for(RequirementType child : this.children){
            if(child.getProductType() instanceof ElementType) {
                list.add(child);
            }else {
                list.addAll((child.getProductType()).getAllElement());
            }
        }
        return list;
    }

    @Override
    public ResourceType getResourceType(){
        throw new UnsupportedOperationException("Not an element.");
    }

    @Override
    public void setResourceType(ResourceType resourceType){
        throw new UnsupportedOperationException("Not an element.");
    }

    @Override
    public void calculateNumberElements(){
        for(RequirementType rt : getAllElement())
            numElements += rt.getQuantity();
    }

    @Override
    public int getNumberElements(){
        return numElements;
    }
}
