package ConfigurationJSON.KnowledgeBuilder;

import java.util.ArrayList;
import java.util.List;

public class FeatureTypeDTO {

    private String name;
    private List<UnitTypeDTO> unitsType;

    public FeatureTypeDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UnitTypeDTO> getUnitsType() {
        return unitsType;
    }

    public void setUnitsType(List<UnitTypeDTO> unitsType) {
        this.unitsType = new ArrayList<>(unitsType);
    }
}
