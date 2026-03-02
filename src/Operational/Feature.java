package Operational;

import Knowledge.FeatureType;

import java.util.ArrayList;
import java.util.List;

public class Feature {

    private static int counter = 0;
    private final int id;
    private FeatureType type;
    private List<Unit> units = new ArrayList<Unit>();

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

    public List<Unit> getUnits() {
        return units;
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }
}
