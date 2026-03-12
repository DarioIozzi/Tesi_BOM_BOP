package Knowledge.Units;

import Knowledge.UnitType;

public class Width extends UnitType {

    public Width(Object value) {

        super(value);
        this.unitOfMeasure = "cm";
        this.unitClass = Double.class;
        this.name = "Width";
    }
}
