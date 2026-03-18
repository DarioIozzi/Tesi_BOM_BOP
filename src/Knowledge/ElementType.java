package Knowledge;

import java.util.List;

public class ElementType extends ProductType{

    private ResourceType resourceType;

    public ElementType(String family, List<FeatureType> ft, ProcessType pt, ResourceType resourceType, String code) {
        super(pt, family, ft, code);
        this.resourceType = resourceType;
    }

    public ElementType(){                   //Per test
        super();
    }

    @Override
    public void addProductType(IntProductTypeData p){
        throw new UnsupportedOperationException("Not a composite.");
    }

    @Override
    public boolean removeProductType(int i, int q){
        throw new UnsupportedOperationException("Not a composite.");
    }

    @Override
    public IntProductTypeData getChild(int i){
        throw new UnsupportedOperationException("Not a composite.");
    }

    @Override
    public List<IntProductTypeData> getChildren(){
        throw new UnsupportedOperationException("Not a composite.");
    }

    @Override
    public List<ProductType> getAllElement(){
        throw new UnsupportedOperationException("Not a composite.");
    }

    public ResourceType getResourceType(){
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType){
        this.resourceType = resourceType;
    }
}
