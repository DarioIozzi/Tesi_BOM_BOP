package Knowledge;

import java.util.HashMap;
import java.util.Map;

public class FeatureType {
    private final int id;
    private String name;
    private Map<String, UnitType> unitsType = new HashMap<>();

    public FeatureType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, UnitType> getUnitsType() {
        return unitsType;
    }

    public UnitType getUnitType(String name) {
        return unitsType.get(name);
    }
}
