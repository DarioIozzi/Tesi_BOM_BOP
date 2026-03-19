package ConfigurationJSON.KnowledgeBuilder;

import java.util.ArrayList;
import java.util.List;

public class ResourceTypeDTO {

    private List<FeatureTypeDTO> featureTypes;
    private int family;

    public ResourceTypeDTO() {}

    public int getFamily() {
        return family;
    }

    public void setFamily(int family) {
        this.family = family;
    }

    public List<FeatureTypeDTO> getFeatureTypes() {
        return featureTypes;
    }

    public void setFeatureTypes(List<FeatureTypeDTO> featureTypes) {
        this.featureTypes = new ArrayList<>(featureTypes);
    }
}
