package Knowledge;

import java.util.*;

public class CompositeType extends ProductType{

    private final List<IntProductTypeData> children;

    public CompositeType(ProcessType pt, String family, List<FeatureType> ft, List<IntProductTypeData> children, String code) {

        super(pt, family, ft, code);
        this.children = new ArrayList<>(Objects.requireNonNull(children, "children cannot be null"));
    }

    public CompositeType(){                         //Per test
        super();
        this.children = new ArrayList<>();
    }

    @Override
    public void addProductType(IntProductTypeData pt) {

        for(IntProductTypeData child : this.children){
            if(child.getProductType().getId() == pt.getProductType().getId()){
                child.modifyQuantity(pt.getQuantity());
                return;
            }
        }
        children.add(new IntProductTypeData(pt.getQuantity(), pt.getProductType()));
    }

    @Override
    public boolean removeProductType(int i, int q){

        Iterator<IntProductTypeData> it = this.children.iterator();

        while (it.hasNext()) {
            IntProductTypeData child = it.next();
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
    public IntProductTypeData getChild(int i) {
        for (IntProductTypeData child : children) {
            if(child.getProductType().getId() == i){
                return child;
            }else if(child.getProductType() instanceof CompositeType){
                IntProductTypeData result = child.getProductType().getChild(i);
                if (result != null)
                    return result;
            }
        }
        return null;
    }

    @Override
    public List<IntProductTypeData> getChildren(){
        return children;
    }

    @Override
    public List<ProductType> getAllElement(){

        List<ProductType> list = new ArrayList<>();
        for(IntProductTypeData child : this.children){
            if(child.getProductType() instanceof ElementType) {
                list.add(child.getProductType());
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
}
