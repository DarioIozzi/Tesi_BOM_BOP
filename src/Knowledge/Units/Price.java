package Knowledge.Units;

import Knowledge.UnitType;

public class Price extends UnitType {

    public Price(Object value, String code) {
        super(value, code);
        this.unitClass = Double.class;
        this.name = "Price";
        this.unitOfMeasure = "Euro";
    }
}
