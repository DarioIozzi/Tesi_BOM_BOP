package Knowledge;

import java.util.ArrayList;
import java.util.List;

public class ElementType extends ProductType{

    private List<FeatureType> featureTypes = new ArrayList<>();
    private final int id;
    private final String family;

    public ElementType(int id, String family, List<FeatureType> fts) {
        this.id = id;
        this.family = family;
        this.featureTypes = new ArrayList<>(fts);
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
}
