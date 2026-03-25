package Knowledge.Units;

import Knowledge.UnitType;

public class Thickness extends UnitType {

    public Thickness(Object value, String code) {

        super(value, code);
        this.unitOfMeasure = "cm";
        this.unitClass = Double.class;
        this.name = "Thickness";
    }
}
