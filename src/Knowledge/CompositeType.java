package Knowledge;

import Others.IntProductTypeData;

import java.util.*;

public class CompositeType extends ProductType{

    private final List<IntProductTypeData> children;

    public CompositeType(ProcessType pt, String family, List<FeatureType> ft, List<IntProductTypeData> children) {

        super(pt, family, ft);
        this.children = new ArrayList<>(Objects.requireNonNull(children, "children cannot be null"));
    }

    @Override
    public int getId(){
        return id;
    }

    @Override
    public boolean isThere(FeatureType ft){
        throw new UnsupportedOperationException("Not an elementType");          //TODO
    }

    @Override
    public void addProductType(IntProductTypeData pt) {

        if(this.Contain(pt.getProductType())){
            for(IntProductTypeData child : this.children){
                if(child.getProductType().getId() == pt.getProductType().getId()){
                    child.modifyQuantity(pt.getQuantity());
                }
            }
        }else {
            children.add(new IntProductTypeData(pt.getQuantity(), pt.getProductType()));
        }
    }

    @Override
    public boolean removeProductType(int id){
        return children.remove(id) != null;
    }

    @Override
    public IntProductTypeData getChild(int i) {
        return children.get(i);
    }

    public List<IntProductTypeData> getChildren(){
        return children;
    }

    public boolean Contain(ProductType pt){
        for(IntProductTypeData child : this.children){
            if(child.getProductType().getId() == pt.getId()){
                return true;
            }
        }
        return false;
    }
}
