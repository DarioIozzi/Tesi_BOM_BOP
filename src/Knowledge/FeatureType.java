package Knowledge;

import java.util.*;

public class FeatureType {

    private static int counter = 0;
    private final int id;
    private String name;
    private final List<UnitType> unitTypes;
    private String code;

    public FeatureType(String name, List<UnitType> uts) {
        this.id = counter++;
        this.name = name;
        this.unitTypes = new ArrayList<>(Objects.requireNonNull(uts, "unitTypes cannot be null"));
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

    public List<UnitType> getUnitTypes() {
        return unitTypes;
    }

    public UnitType getUnitType(int i) {

        for (UnitType ut : unitTypes) {
            if (ut.getId() == i)
                return ut;
        }
        return null;
    }

    public void addUnitType(UnitType unitType) {
        unitTypes.add(unitType);
    }

    public boolean removeUnitType(int i) {

        Iterator<UnitType> it = unitTypes.iterator();

        while (it.hasNext()) {
            UnitType ut = it.next();
            if (ut.getId() == i) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
