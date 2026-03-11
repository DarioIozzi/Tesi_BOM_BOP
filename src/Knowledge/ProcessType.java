package Knowledge;

import java.util.ArrayList;
import java.util.List;

public class ProcessType {

    private static int counter = 0;
    private final int id;
    private String family;
    private List<FeatureType> featureTypes = new ArrayList<>();

    public ProcessType(String family, List<FeatureType> ft) {
        this.id = counter++;
        this.family = family;
        if (ft != null)
            this.featureTypes = new ArrayList<>(ft);
    }

    public ProcessType(String family) {
        this.id = counter++;
        this.family = family;
    }

    public int getId() {
        return id;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void addFeatureType(FeatureType featureType) {
        featureTypes.add(featureType);
    }

    public List<FeatureType> getFeatureTypes() {
        return featureTypes;
    }
}
