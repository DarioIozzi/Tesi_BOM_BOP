package Operational;

import Knowledge.ObservationType;

public class Observation {

    private ObservationType type;
    private final int id;
    private String text;

    Observation(int id, ObservationType type) {
        this.id = id;
        this.type = type;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public ObservationType getType() {
        return type;
    }

    public void setType(ObservationType type) {
        this.type = type;
    }
}
