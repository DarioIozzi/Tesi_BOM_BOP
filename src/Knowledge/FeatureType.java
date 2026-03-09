package Knowledge;

import java.util.HashMap;
import java.util.Map;

public class FeatureType {

    private static int counter = 0;
    private final int id;
    private String name;
    private Map<String, UnitType> unitTypes = new HashMap<>();

    public FeatureType(String name, Map<String, UnitType> uts) {
        this.id = counter++;
        this.name = name;
        if(uts != null)
            this.unitTypes = new HashMap<>(uts);
    }

    public FeatureType(String name) {
        this.id = counter++;
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

    public Map<String, UnitType> getUnitTypes() {
        return unitTypes;
    }

    public UnitType getUnitType(String name) {
        return unitTypes.get(name);
    }

    public void addUnitType(UnitType unitType) {
        unitTypes.put(unitType.getName(), unitType);
    }

    public boolean removeUnitType(String type) {
        return unitTypes.remove(type) != null;
    }
}
