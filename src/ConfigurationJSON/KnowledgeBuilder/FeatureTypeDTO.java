package ConfigurationJSON.KnowledgeBuilder;

import Knowledge.UnitType;

import java.util.ArrayList;
import java.util.List;

public class FeatureTypeDTO {

    private String name;
    private List<UnitType> unitsType;

    public FeatureTypeDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UnitType> getUnitsType() {
        return unitsType;
    }

    public void setUnitsType(List<UnitType> unitsType) {
        this.unitsType = new ArrayList<>(unitsType);
    }
}
