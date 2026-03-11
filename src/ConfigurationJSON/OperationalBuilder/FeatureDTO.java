package ConfigurationJSON.OperationalBuilder;

import Knowledge.FeatureType;
import Operational.Unit;

import java.util.ArrayList;
import java.util.List;

public class FeatureDTO {

    private FeatureType type;
    private List<Unit> units;

    public void setType(FeatureType type) {
        this.type = type;
    }

    public void setUnits(List<Unit> units) {
        this.units = new ArrayList<>(units);
    }

    public FeatureType getType() {
        return type;
    }

    public List<Unit> getUnits() {
        return units;
    }
}
