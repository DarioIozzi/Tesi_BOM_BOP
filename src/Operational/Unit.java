package Operational;

import Knowledge.UnitType;

public class Unit {

    private static int counter = 0;
    private final int id;
    private UnitType unittype;
    private Object value;

    public Unit(UnitType unittype, Object value) {
        this.id = counter++;
        this.unittype = unittype;

        if(isValid(value))
            this.value = value;
        else
            throw new IllegalArgumentException("Invalid value");
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

    public UnitType getUnittype() {
        if (unittype == null)
            //TODO gestisci con eccezione
        return unittype;
    }

    public void setUnittype(UnitType unittype) {
        this.unittype = unittype;
    }

    public boolean isValid(Object v){
        if (v != null && unittype.getUnitClass() == String.class)
            return true;
        else if (v instanceof Number && ((Number) v).doubleValue() >= 0 && unittype.getUnitClass() == Number.class)
            return true;
        else if (v instanceof )        //TODO Time

        return false;
    }
}
