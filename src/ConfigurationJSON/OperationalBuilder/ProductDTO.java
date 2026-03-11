package ConfigurationJSON.OperationalBuilder;

import Knowledge.ProductType;

public class ProductDTO {

    private ProcessDTO process;
    private ProductType type;

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
