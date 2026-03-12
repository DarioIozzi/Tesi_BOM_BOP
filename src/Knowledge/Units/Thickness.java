package Knowledge.Units;

import Knowledge.UnitType;

public class Thickness extends UnitType {

    public Thickness(Object value) {

        super(value);
        this.unitOfMeasure = "cm";
        this.unitClass = Double.class;
        this.name = "Thickness";
    }
}
