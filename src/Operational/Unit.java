package Operational;

import Knowledge.UnitType;

import java.time.Duration;

public class Unit {

    private static int counter = 0;
    private final int id;
    private UnitType unitType;
    private Object value;

    public Unit(UnitType unitType, Object value) {
        this.unitType = unitType;

        if(isValid(value))
            this.value = value;
        else
            throw new IllegalArgumentException("Invalid value");

        this.id = counter++;
    }

    public int getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        if(isValid(value))
            this.value = value;
        else
            throw new IllegalArgumentException("Invalid value");
    }

    public UnitType getUnitType() {
        if (unitType == null)
            throw new IllegalStateException("Unit type is null, it must be set");
        return unitType;
    }

    public void setUnitType(UnitType unittype) {
        this.unitType = unittype;
    }

    public boolean isValid(Object v){
        if (v instanceof String && unitType.getUnitClass() == String.class)
            return true;
        else if (v instanceof Number && ((Number) v).doubleValue() >= 0 && unitType.getUnitClass() == Double.class)
            return true;
        else if (v instanceof Duration && !((Duration) v).isNegative() && unitType.getUnitClass() == Duration.class)
            return true;

        return false;
    }
}
