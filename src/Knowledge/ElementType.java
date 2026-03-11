package Knowledge;

import java.util.List;

public class ElementType extends ProductType{

    private ResourceType resourceType;

    public ElementType(String family, List<FeatureType> ft, ProcessType pt, ResourceType resourceType) {
        super(pt, family, ft);
        this.resourceType = resourceType;
    }

    @Override
    public int getId(){
        return id;
    }

    public String getFamily(){
        return family;
    }

    public FeatureType getFeatureType(int id){
        for(FeatureType f : featureTypes){
            if (f.getId() == id)
                    return f;
        }
        return null;
    }

    public List<FeatureType> getFeatureTypes(){
        return featureTypes;
    }

    public void addFeatureType(FeatureType f){
        featureTypes.add(f);
    }

    public boolean removeFeatureType(int id){
        return featureTypes.remove(id) != null;
    }

    public boolean isThere(FeatureType ft){
        for(FeatureType f : featureTypes){
            if(f.getId() == ft.getId())
                return true;
        }
        return false;
    }

    public ResourceType getResourceType(){
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType){
        this.resourceType = resourceType;
    }
}
