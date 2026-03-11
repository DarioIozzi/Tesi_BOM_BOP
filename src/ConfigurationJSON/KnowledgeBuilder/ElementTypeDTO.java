package ConfigurationJSON.KnowledgeBuilder;

public class ElementTypeDTO extends ProductTypeDTO{

    ResourceTypeDTO resourceType;

    public ElementTypeDTO() {}

    public void setResourceType(ResourceTypeDTO resourceType) {
        this.resourceType = resourceType;
    }

    public ResourceTypeDTO getResourceType() {
        return resourceType;
    }
}
