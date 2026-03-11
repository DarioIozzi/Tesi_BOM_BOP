package Operational;

import Knowledge.ProcessType;

import java.util.ArrayList;
import java.util.List;

public class Process {

    private static int counter = 0;
    private final int id;
    private ProcessType type;
    private List<Feature> featureList = new ArrayList<>();

    public Process(ProcessType type) {

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

    public void addFeature(Feature feature) {
        featureList.add(feature);
    }

    public List<Feature> getFeatures(){
        return featureList;
    }
}
