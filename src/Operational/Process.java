package Operational;

import Knowledge.ProcessType;

public class Process {

    private static int counter = 0;
    private final int id;
    private ProcessType type;

    public Process(ProcessType type, Resource resource) {

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
