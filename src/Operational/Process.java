package Operational;

import Knowledge.ProcessType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Process {

    private static int counter = 0;
    private final int id;
    private ProcessType type;
    private List<Feature> featureList;

    public Process(ProcessType type, List<Feature> featureList) {

        this.featureList = new ArrayList<>(Objects.requireNonNull(featureList));
        this.id = counter++;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public ProcessType getType() {
        return type;
    }

    public void setType(ProcessType type) {
        this.type = type;
    }
}
