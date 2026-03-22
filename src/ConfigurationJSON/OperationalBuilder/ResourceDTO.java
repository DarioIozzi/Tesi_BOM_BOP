package ConfigurationJSON.OperationalBuilder;

import java.util.List;

public class ResourceDTO {

    private List<FeatureDTO> features;
    private int lotto;
    private String code;

    public ResourceDTO(){}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
