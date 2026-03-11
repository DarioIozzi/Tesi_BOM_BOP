package ConfigurationJSON.OperationalBuilder;

import Operational.Resource;

public class ElementDTO extends ProductDTO{

    private Resource resource;

    public ElementDTO() {}

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Resource getResource() {
        return resource;
    }
}
