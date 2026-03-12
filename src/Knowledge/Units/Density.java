package Knowledge.Units;

import Knowledge.UnitType;

public class Density extends UnitType { //TODO singleton

    public Density(Object value) {

        super(value);
        this.unitOfMeasure = "kg/m^3";
        this.unitClass = Double.class;
        this.name = "Density";
    }
}
