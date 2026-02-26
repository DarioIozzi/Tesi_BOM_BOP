package Operational;

import Knowledge.FeatureType;

import java.util.ArrayList;
import java.util.List;

public class Feature {

    private final int id;
    FeatureType type;
    List<Unit> units = new ArrayList<Unit>();

    public Feature(int id, FeatureType type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public FeatureType getType() {
        return type;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }
}
