package ConfigurationJSON.OperationalBuilder;

import ConfigurationJSON.KnowledgeBuilder.ProcessTypeDTO;
import Knowledge.ProcessType;

import java.util.List;

public class ProcessDTO {

    private ProcessType processType;

    public ProcessDTO() {}

    public void setProcessType(ProcessType processType) {
        this.processType = processType;
    }

    public ProcessType getProcessType() {
        return processType;
    }
}
