package Operational;

import Knowledge.UnitType;

public class Unit {

    private final int id;
    private UnitType unittype;
    private Object value;

    public Unit(int id, UnitType unittype, Object value) {
        this.id = id;
        this.unittype = unittype;

        if(isValid(value))
            this.value = value;         //TODO if value not valid?
    }

    public int getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public UnitType getUnittype() {
        return unittype;
    }

    public boolean isValid(Object v){
        if (v != null && unittype.getUnitClass() == String.class)
            return true;
        else if (v instanceof Number && ((Number) v).doubleValue() >= 0 && unittype.getUnitClass() == Number.class)
            return true;
        else if (v instanceof )        //TODO Time

        return false;
    }

                //TODO add check on types
}
