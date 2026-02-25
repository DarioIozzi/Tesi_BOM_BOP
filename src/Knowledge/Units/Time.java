package Knowledge.Units;

import Knowledge.UnitType;

public class Time extends UnitType {

    public Time() {
        this.unitOfMeasure = "s";
        this.unitClass = java.time.Duration.class;
        this.name = "Time";
    }
}
