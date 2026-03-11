package ConfigurationJSON.OperationalBuilder;

import Knowledge.ResourceType;

import java.util.List;

public class ResourceDTO {

    private List<FeatureDTO> features;
    private int lotto;
    private ResourceType resourceType;

    public ResourceDTO(){}

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public List<FeatureDTO> getFeatures() {
        return features;
    }

    public void setFeatures(List<FeatureDTO> features) {
        this.features = features;
    }

    public int getLotto() {
        return lotto;
    }

    public void setLotto(int lotto) {
        this.lotto = lotto;
    }
}
