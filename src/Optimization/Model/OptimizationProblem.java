package Optimization.Model;

import Optimization.Cost.CostMatrix;

import java.util.List;

public class OptimizationProblem {

    private final List<Node> nodes;
    private final CostMatrix cm;

    public OptimizationProblem(List<Node> nodes, CostMatrix cm) {
        this.nodes = nodes;
        this.cm = cm;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public CostMatrix getCm() {
        return cm;
    }
}
