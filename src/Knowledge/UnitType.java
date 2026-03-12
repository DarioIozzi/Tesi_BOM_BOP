package Knowledge;

import Knowledge.Units.*;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Length.class, name = "Length"),
        @JsonSubTypes.Type(value = Weight.class, name = "Weight"),
        @JsonSubTypes.Type(value = Density.class, name = "Density"),
        @JsonSubTypes.Type(value = Time.class, name = "Time"),
        @JsonSubTypes.Type(value = Thickness.class, name = "Thickness"),
        @JsonSubTypes.Type(value = Width.class, name = "Width"),
        @JsonSubTypes.Type(value = Text.class, name = "Text")
})

public abstract class UnitType {

    private static int counter = 0;
    protected int id;
    protected String name;
    protected Class<?> unitClass;
    protected String unitOfMeasure;
    protected Object unitValue;

    public UnitType(Object value){

        this.id = counter++;
        this.unitValue = value;
    }

    public String getName(){
        return name;
    }
    public Class<?> getUnitClass(){
        return unitClass;
    }

    public String getUnitOfMeasure(){
        return unitOfMeasure;
    }

    public Object getUnitValue(){
        return unitValue;
    }

    public int getId(){
        return id;
    }
}
