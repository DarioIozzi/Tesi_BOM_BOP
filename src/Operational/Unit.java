package Operational;

import Knowledge.UnitType;

import java.time.Duration;

public class Unit {

    private static int counter = 0;
    private final int id;
    private UnitType unittype;
    private Object value;

    public Unit(UnitType unittype, Object value) {
        this.unittype = unittype;

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
        if (unittype == null)
            throw new IllegalStateException("Unit type is null, it must be set");
        return unittype;
    }

    public void setUnitType(UnitType unittype) {
        this.unittype = unittype;
    }

    public boolean isValid(Object v){
        if (v != null && unittype.getUnitClass() == String.class)
            return true;
        else if (v instanceof Number && ((Number) v).doubleValue() >= 0 && unittype.getUnitClass() == Double.class)
            return true;
        else if (v instanceof Duration && !((Duration) v).isNegative())
            return true;

        return false;
    }
}
