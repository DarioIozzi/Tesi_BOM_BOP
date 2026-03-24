package Operational;

import Knowledge.ObservationType;

public class Observation {

    private static int counter = 0;
    private ObservationType type;
    private final int id;
    private String text;

    public Observation(String text) {
        this.id = counter++;
        this.text = text;
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
