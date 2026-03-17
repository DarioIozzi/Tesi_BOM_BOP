package ConfigurationJSON.OperationalBuilder;

import Knowledge.ObservationType;

public class ObservationDTO {

    private ObservationType type;
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public ObservationType getType() {
        return type;
    }

    public void setType(ObservationType type) {
        this.type = type;
    }
}
