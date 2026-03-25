package Knowledge.Units;

import Knowledge.UnitType;

public class Text extends UnitType {

    public Text(Object value, String code) {

        super(value, code);
        this.unitOfMeasure = "caratteri";
        this.unitClass = String.class;
        this.name = "Text";
    }
}
