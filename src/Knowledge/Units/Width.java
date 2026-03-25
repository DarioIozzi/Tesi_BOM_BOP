package Knowledge.Units;

import Knowledge.UnitType;

public class Width extends UnitType {

    public Width(Object value, String code) {

        super(value, code);
        this.unitOfMeasure = "cm";
        this.unitClass = Double.class;
        this.name = "Width";
    }
}
