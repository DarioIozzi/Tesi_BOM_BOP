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
    public void addProductType(RequirementType p){
        throw new UnsupportedOperationException("Not a composite.");
    }

    @Override
    public boolean removeProductType(int i, int q){
        throw new UnsupportedOperationException("Not a composite.");
    }

    @Override
    public RequirementType getChild(int i){
        throw new UnsupportedOperationException("Not a composite.");
    }

    @Override
    public List<RequirementType> getChildren(){
        throw new UnsupportedOperationException("Not a composite.");
    }

    @Override
    public List<ProductType> getAllElement(){
        throw new UnsupportedOperationException("Not a composite.");
    }

    @Override
    public ResourceType getResourceType(){
        return resourceType;
    }

    @Override
    public void setResourceType(ResourceType resourceType){
        this.resourceType = resourceType;
    }

    @Override
    public void setNumberElements(){
        throw new UnsupportedOperationException("Not a composite.");
    }

    @Override
    public int getNumberElements(){
        throw new UnsupportedOperationException("Not a composite.");
    }
}
