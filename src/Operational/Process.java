package Operational;

import Knowledge.ProcessType;

import java.util.ArrayList;
import java.util.List;

public class Process {

    public enum Status{
        READY,
        IN_PROGRESS,
        COMPLETE,
        FAILED
    }

    private Status status;
    private static int counter = 0;
    private final int id;
    private ProcessType type;
    private final List<Feature> featureList = new ArrayList<>();
    private final List<Observation> observations = new ArrayList<>();

    public Process(ProcessType type) {

        this.id = counter++;
        this.type = type;
        this.status = Status.READY;
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

    public List<Observation> getObservation() {
        return observations;
    }

    public void addObservation(Observation observation) {
        this.observations.add(observation);
    }

    public void removeObservaion(int id){
        this.observations.remove(id);
    }

    public Status getStatus() {
        return status;
    }

    public void start(){
        status = Status.IN_PROGRESS;
    }

    public void completed(){
        status = Status.COMPLETE;
    }

    public void failed(){
        status = Status.FAILED;
    }
}
