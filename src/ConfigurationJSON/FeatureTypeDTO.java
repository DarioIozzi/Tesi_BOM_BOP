package ConfigurationJSON;

import Knowledge.UnitType;

import java.util.HashMap;
import java.util.Map;

public class FeatureTypeDTO {

    private String name;
    private Map<String, UnitType> unitsType;

    public FeatureTypeDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, UnitType> getUnitsType() {
        return unitsType;
    }

    public void setUnitsType(Map<String, UnitType> unitsType) {
        this.unitsType = new HashMap<>(unitsType);
    }
}
