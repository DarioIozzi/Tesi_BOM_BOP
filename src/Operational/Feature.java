package Operational;

import Knowledge.FeatureType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Feature {

    private static int counter = 0;
    private final int id;
    private FeatureType type;
    private final List<Unit> units;

    public Feature(FeatureType type, List<Unit> units) {

        this.units = new ArrayList<>(Objects.requireNonNull(units, "units cannot be null"));
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
