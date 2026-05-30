package Optimization.Solver;

import Optimization.Cost.CostMatrix;
import Optimization.Model.OptimizationProblem;
import com.google.ortools.Loader;
import com.google.ortools.constraintsolver.*;

public class OrToolsSolver implements Solver {

    private CostMatrix costMatrix;

    OrToolsSolver(CostMatrix cm) {
        Loader.loadNativeLibraries();
        costMatrix = cm;
    }

    private void addConstraints(){

    }

    @Override
    public void solve(OptimizationProblem problem) {

        RoutingIndexManager manager = new RoutingIndexManager(problem.getNodes().size(), 1, 0);

        RoutingModel routing = new RoutingModel(manager);

        int transitCallbackIndex =
                routing.registerTransitCallback(
                        (long fromIndex, long toIndex) -> {

                            int fromNode =
                                    manager.indexToNode(fromIndex);

                            int toNode =
                                    manager.indexToNode(toIndex);

                            return costMatrix.getCost(fromNode, toNode);
                        }
                );

        routing.setArcCostEvaluatorOfAllVehicles(transitCallbackIndex);

        RoutingSearchParameters params = RoutingSearchParameters.newBuilder().setFirstSolutionStrategy(FirstSolutionStrategy.Value.PATH_CHEAPEST_ARC).build();

        Assignment solution = routing.solveWithParameters(params);

        if(solution != null){

            long index = routing.start(0);

            System.out.println("Percorso ottimizzato");

            while(!routing.isEnd(index)){
                int node = manager.indexToNode(index);

                System.out.println(node + " -> ");

                index = solution.value(routing.nextVar(index));
            }

            System.out.println("FINE");
        }
    }
}
