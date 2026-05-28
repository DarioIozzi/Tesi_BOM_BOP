package Optimization.Model;

import Optimization.Constraints.Constraint;
import Optimization.Cost.CostMatrix;

import java.util.List;

public class OptimizationProblem {

    private final List<Node> nodes;
    private final CostMatrix cm;
    private final List<Constraint> constraints;

    OptimizationProblem(List<Node> nodes, CostMatrix cm, List<Constraint> constraints) {
        this.nodes = nodes;
        this.cm = cm;
        this.constraints = constraints;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public CostMatrix getCm() {
        return cm;
    }

    public List<Constraint> getConstraints() {
        return constraints;
    }
}
