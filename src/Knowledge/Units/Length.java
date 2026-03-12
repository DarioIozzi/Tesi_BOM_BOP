package Knowledge.Units;

import Knowledge.UnitType;

public class Length extends UnitType{

    public Length(Object value) {

        super(value);
        this.unitOfMeasure = "cm";
        this.unitClass = Double.class;
        this.name = "Length";
    }
}
