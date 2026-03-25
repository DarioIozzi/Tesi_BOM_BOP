package Knowledge.Units;

import Knowledge.UnitType;

public class Density extends UnitType {

    public Density(Object value, String code) {

        super(value, code);
        this.unitOfMeasure = "kg/m^3";
        this.unitClass = Double.class;
        this.name = "Density";
    }
}
