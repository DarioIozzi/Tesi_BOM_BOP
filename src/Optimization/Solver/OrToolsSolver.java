package Optimization.Solver;

import Optimization.Model.Node;
import Optimization.Model.OptimizationProblem;
import com.google.ortools.Loader;
import com.google.ortools.constraintsolver.*;

public class OrToolsSolver implements Solver {

    public OrToolsSolver() {
        Loader.loadNativeLibraries();
    }

    @Override
    public void solve(OptimizationProblem problem) {

        RoutingIndexManager manager = new RoutingIndexManager(problem.getNodes().size(), 1, 1);

        RoutingModel routing = new RoutingModel(manager);

        int transitCallbackIndex =
                routing.registerTransitCallback(
                        (long fromIndex, long toIndex) -> {

                            int fromNode = manager.indexToNode(fromIndex);

                            int toNode = manager.indexToNode(toIndex);

                            return problem.getCm().getCost(fromNode, toNode);
                        }
                );

        routing.setArcCostEvaluatorOfAllVehicles(transitCallbackIndex);

        int timeCallbackIndex =
                routing.registerTransitCallback(
                        (long notUsefull, long index) -> {

                            int node = manager.indexToNode(index);

                            return problem.getNodes().get(node).getProductionTime();
                        }
                );

        routing.addDimension(timeCallbackIndex, 0, 10000, true, "TIME");

        RoutingDimension timeDimension = routing.getMutableDimension("TIME");

        for (int i = 1; i < problem.getNodes().size(); i++) {

            long deadline =
                    problem.getNodes()
                            .get(i)
                            .getDeadline();

            long index =
                    manager.nodeToIndex(i);

            timeDimension
                    .cumulVar(index)
                    .setMax(deadline);
        }

        RoutingSearchParameters params = RoutingSearchParameters.newBuilder().setFirstSolutionStrategy(FirstSolutionStrategy.Value.PATH_CHEAPEST_ARC).build();

        Assignment solution = routing.solveWithParameters(params);

        if(solution != null){

            long index = routing.start(0);

            System.out.println("Percorso ottimizzato");

            while (!routing.isEnd(index)) {

                int node = manager.indexToNode(index);

                long cumulativeTime = solution.value(timeDimension.cumulVar(index));

                Node n = problem.getNodes().get(node);

                long deadline = n.getDeadline();

                System.out.println("Requirement: " + n.getRequirement().toString() + " | Ordine: " + n.getOrder().getId() + " | Tempo accumulato: " + cumulativeTime + " | Deadline: " + deadline);

                index = solution.value(routing.nextVar(index));
            }

            long finalTime = solution.value(timeDimension.cumulVar(index));

            System.out.println("FINE | Tempo accumulato: " + finalTime + " ! Costo totale: " + solution.objectiveValue());
        }
    }
}
