package ConfigurationJSON.KnowledgeBuilder;

import java.util.ArrayList;
import java.util.List;

public class FeatureTypeDTO {

    private String code;
    private String name;
    private List<UnitTypeDTO> unitTypes;

    public FeatureTypeDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UnitTypeDTO> getUnitTypes() {
        return unitTypes;
    }

    public void setUnitTypes(List<UnitTypeDTO> unitsType) {
        this.unitTypes = new ArrayList<>(unitsType);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
