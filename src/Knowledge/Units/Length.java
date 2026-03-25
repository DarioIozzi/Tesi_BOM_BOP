package Knowledge.Units;

import Knowledge.UnitType;

public class Length extends UnitType{

    public Length(Object value, String code) {

        super(value, code);
        this.unitOfMeasure = "cm";
        this.unitClass = Double.class;
        this.name = "Length";
    }
}
