package Knowledge.Units;

import Knowledge.UnitType;

public class Weight extends UnitType {

    public Weight(Object value, String code) {

        super(value, code);
        this.unitOfMeasure = "kg";
        this.unitClass = Double.class;
        this.name = "Weight";
    }
}
