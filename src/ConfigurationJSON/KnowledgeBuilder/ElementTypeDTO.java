package ConfigurationJSON.KnowledgeBuilder;

public class ElementTypeDTO extends ProductTypeDTO{

    private ResourceTypeDTO resourceType;

    public ElementTypeDTO() {}

    public void setResourceType(ResourceTypeDTO resourceType) {
        this.resourceType = resourceType;
    }

    public ResourceTypeDTO getResourceType() {
        return resourceType;
    }
}
