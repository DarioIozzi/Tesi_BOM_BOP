package Knowledge;

import java.util.ArrayList;
import java.util.List;

public class ElementType extends ProductType{

    private static int counter = 0;
    private List<FeatureType> featureTypes = new ArrayList<>();
    private final int id;
    private final String family;

    public ElementType(String family, List<FeatureType> fts) {
        this.id = counter++;
        this.family = family;
        if(fts != null)
            this.featureTypes = new ArrayList<>(fts);
    }

    public ElementType(String family) {
        this.id = counter++;
        this.family = family;
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
