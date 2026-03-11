package ConfigurationJSON.KnowledgeBuilder;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "child"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ElementTypeDTO.class, name = "element"),
        @JsonSubTypes.Type(value = CompositeTypeDTO.class, name = "composite")
})

public abstract class ProductTypeDTO {

    private List<FeatureTypeDTO> featureTypes;
    private String family;
    private ProcessTypeDTO processType;

    public ProductTypeDTO() {}

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public List<FeatureTypeDTO> getFeatureTypes() {
        return featureTypes;
    }

    public void setFeatureTypes(List<FeatureTypeDTO> featureTypes) {
        this.featureTypes = new ArrayList<>(featureTypes);
    }

    public ProcessTypeDTO getProcessType() {
        return processType;
    }

    public void setProcessType(ProcessTypeDTO processType) {
        this.processType = processType;
    }
}
