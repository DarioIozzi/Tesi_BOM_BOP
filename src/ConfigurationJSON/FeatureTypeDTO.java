package ConfigurationJSON;

import Knowledge.UnitType;

import java.util.Map;

public class FeatureTypeDTO {

    private String name;
    private Map<String, UnitType> unitsType;

    public String getName() {
        return name;
    }

    public Map<String, UnitType> getUnitsType() {
        return unitsType;
    }
}
