package Knowledge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProcessType {

    private static int counter = 0;
    private final int id;
    private String family;
    private final List<FeatureType> featureTypes;
    private final List<ObservationType> observationTypes;

    public ProcessType(String family, List<FeatureType> ft, List<ObservationType> obs) {
        this.id = counter++;
        this.family = family;
        this.observationTypes = new ArrayList<>(Objects.requireNonNull(obs, "ObservationTypes cannot be null"));

        this.featureTypes = new ArrayList<>(Objects.requireNonNull(ft,"FeatureTypes cannot be null"));
    }

    public ProcessType(){                               //Per test
        this.id = counter++;
        this.featureTypes = new ArrayList<>();
        this.observationTypes = new ArrayList<>();
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

    public List<ObservationType> getObservationType() {
        return observationTypes;
    }

    public void addObservationType(ObservationType obs) {
        observationTypes.add(Objects.requireNonNull(obs, "ObservationType cannot be null"));
    }
}
