package ConfigurationJSON.OperationalBuilder;

import Knowledge.ProductType;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {

    private List<FeatureDTO> features;
    private ProcessDTO process;
    private ProductType type;

    public List<FeatureDTO> getFeatures() {
        return features;
    }

    public void setFeatures(List<FeatureDTO> features) {
        this.features = new ArrayList<>(features);
    }

    public ProcessDTO getProcess() {
        return this.process;
    }

    public void setProcess(ProcessDTO process) {
        this.process = process;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
}
