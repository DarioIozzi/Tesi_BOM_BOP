package ConfigurationJSON.KnowledgeBuilder;

import ConfigurationJSON.KnowledgeBuilder.Units.*;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = LengthDTO.class, name = "Length"),
        @JsonSubTypes.Type(value = WeightDTO.class, name = "Weight"),
        @JsonSubTypes.Type(value = DensityDTO.class, name = "Density"),
        @JsonSubTypes.Type(value = TimeDTO.class, name = "Time"),
        @JsonSubTypes.Type(value = ThicknessDTO.class, name = "Thickness"),
        @JsonSubTypes.Type(value = WidthDTO.class, name = "Width"),
        @JsonSubTypes.Type(value = TextDTO.class, name = "Text")
})

public class UnitTypeDTO {

    protected Object unitValue;

    public UnitTypeDTO() {}

    public void setUnitValue(Object unitValue){
        this.unitValue = unitValue;
    }

    public Object getUnitValue(){
        return unitValue;
    }
}
