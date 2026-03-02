package Knowledge;

import java.util.HashMap;
import java.util.Map;

public class FeatureType {

    private static int counter = 0;
    private final int id;
    private String name;
    private Map<String, UnitType> unitsType = new HashMap<>();

    public FeatureType(String name, Map<String, UnitType> uts) {
        this.id = counter++;
        this.name = name;
        this.unitsType = new HashMap<>(uts);
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

    public void addUnitType(UnitType unitType) {
        unitsType.put(unitType.getName(), unitType);
    }

    public boolean removeUnitType(String type) {
        return unitsType.remove(type) != null;
    }
}
