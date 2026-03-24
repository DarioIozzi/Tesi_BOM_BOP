package Knowledge.Units;

import Knowledge.UnitType;

public class Price extends UnitType {

    public Price(Object value) {
        super(value);
        this.unitClass = Double.class;
        this.name = "Price";
        this.unitOfMeasure = "Euro";
    }
}
