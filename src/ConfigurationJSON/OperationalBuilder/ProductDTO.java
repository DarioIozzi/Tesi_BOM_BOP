package ConfigurationJSON.OperationalBuilder;

import Knowledge.ProductType;
import Operational.Process;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {

    private List<FeatureDTO> features;
    private Process process;
    private ProductType type;

    public List<FeatureDTO> getFeatures() {
        return features;
    }

    public void setFeatures(List<FeatureDTO> features) {
        this.features = new ArrayList<>(features);
    }

    public Process getProcess() {
        return this.process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
}
