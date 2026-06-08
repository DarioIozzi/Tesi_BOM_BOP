package Knowledge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class ProductType {

    static int counter = 0;
    int numElements = 0;
    int id;
    String code;
    ProcessType processType;
    String family;
    List<FeatureType> featureTypes;

    ProductType(ProcessType processType, String family, List<FeatureType> featureTypes, String code) {

        this.featureTypes = new ArrayList<>(Objects.requireNonNull(featureTypes, "featureTypes cannot be null"));
        this.id = counter++;
        this.processType = processType;
        this.family = family;
        this.code = code;
    }

    ProductType() {                             //Per test
        this.id = counter++;
        this.featureTypes = new ArrayList<>();
    }

    public static void restCounter(){                      //Per test
        counter = 0;
    }

    public abstract void addProductType(RequirementType pt);

    public abstract boolean removeProductType(int i, int q);

    public abstract RequirementType getChild(int i);

    public abstract List<RequirementType> getChildren();

    public abstract List<RequirementType> getAllElement();

    public ProcessType getProcessType() {
        return processType;
    }

    public List<FeatureType> getFeatureTypes(){
        return featureTypes;
    }

    public FeatureType getFeatureType(int id){
        for(FeatureType f : featureTypes){
            if (f.getId() == id)
                return f;
        }
        return null;
    }

    public FeatureType getFeatureType(String code){
        for(FeatureType f : featureTypes){
            if(f.getCode().equals(code))
                return f;
        }
        return null;
    }

    public String getFamily(){
        return family;
    }

    public void setFamily(String family){
        this.family = family;
    }

    public int getId(){
        return id;
    }

    public String getCode(){
        return code;
    }

    public abstract ResourceType getResourceType();

    public abstract void setResourceType(ResourceType resourceType);

    public abstract void setNumberElements();

    public abstract int getNumberElements();

    @Override
    public String toString() {
        return "{id= " + id + ", family= " + family + "} \n";
    }
}
