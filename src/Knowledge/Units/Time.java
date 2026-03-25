package Knowledge.Units;

import Knowledge.UnitType;

public class Time extends UnitType {

    public Time(Object value, String code) {

        super(value, code);
        this.unitOfMeasure = "s";
        this.unitClass = java.time.Duration.class;
        this.name = "Time";
    }
}
