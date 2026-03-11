package ConfigurationJSON.OperationalBuilder;

import ConfigurationJSON.KnowledgeBuilder.ProcessTypeDTO;
import Knowledge.ProcessType;

import java.util.List;

public class ProcessDTO {

    private ProcessType processType;
    private List<FeatureDTO> features;

    public ProcessDTO() {}

    public void setProcessType(ProcessType processType) {
        this.processType = processType;
    }

    public ProcessType getProcessType() {
        return processType;
    }

    public void setFeatures(List<FeatureDTO> features) {
        this.features = features;
    }

    public List<FeatureDTO> getFeatures() {
        return features;
    }
}
