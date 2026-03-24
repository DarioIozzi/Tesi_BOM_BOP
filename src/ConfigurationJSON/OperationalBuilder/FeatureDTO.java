package ConfigurationJSON.OperationalBuilder;

import java.util.ArrayList;
import java.util.List;

public class FeatureDTO {

    private String type;
    private List<UnitDTO> units;

    public void setType(String type) {
        this.type = type;
    }

    public void setUnits(List<UnitDTO> units) {
        this.units = new ArrayList<>(units);
    }

    public String getType() {
        return type;
    }

    public List<UnitDTO> getUnits() {
        return units;
    }
}
