package Optimization.Constraints;

public class DeadlineConstraint implements Constraint{

    private final long deadline;
    private final int nodeId;

    public DeadlineConstraint(int nodeId, long deadline){
        this.nodeId = nodeId;
        this.deadline = deadline;
    }

    public long getDeadline(){
        return deadline;
    }

    public int getNodeId(){
        return nodeId;
    }

    @Override
    public String getName(){
        return "Deadline Constraint";
    }
}
