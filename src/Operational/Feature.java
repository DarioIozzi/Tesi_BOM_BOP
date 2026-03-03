package Operational;

import Knowledge.FeatureType;

import java.util.ArrayList;
import java.util.List;

public class Feature {

    private static int counter = 0;
    private final int id;
    private FeatureType type;
    private final List<Unit> units = new ArrayList<>();

    public Feature(FeatureType type) {
        this.id = counter++;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public FeatureType getType() {
        return type;
    }

    public void setType(FeatureType type) {
        this.type = type;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }
}
