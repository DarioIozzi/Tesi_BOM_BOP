package Optimization.Builder;

import Operational.OrderManager.Order;
import Operational.Requirement;
import Optimization.Cost.CostMatrix;
import Optimization.Model.Node;
import Optimization.Model.OptimizationProblem;

import java.util.ArrayList;
import java.util.List;

import static Optimization.Cost.CostCalculator.transitCostCalculate;

public class OptimizationProblemBuilder {

    private List<Order> orders;
    private List<Requirement> requirements;

     public OptimizationProblemBuilder(List<Order> orders) {
         this.orders = new ArrayList<>(orders);
         this.requirements = new ArrayList<>(this.getRequirementFromOrders());
     }

     private List<Requirement> getRequirementFromOrders() {
         List<Requirement> rs = new ArrayList<>();
         for (Order o : orders) {
             rs.addAll(o.getProductslist());
         }

         return rs;
     }

     private CostMatrix buildMatrix(){

         CostMatrix costMatrix = new CostMatrix(requirements.size()+1);

         for(int i = 0; i < requirements.size()+1; i++) {
             for (int j = 0; j <requirements.size()+1; j++) {
                 if(i != j) {
                     if(i == 0)
                         costMatrix.setCost(i, j, requirements.get(j).getProduct().getType().getNumberElements() * 2);
                     else if(j == 0)
                         costMatrix.setCost(i, j, requirements.get(i).getProduct().getType().getNumberElements() * 2);
                     else
                        costMatrix.setCost(i, j, transitCostCalculate(requirements.get(i), requirements.get(j)));
                 }
                 else
                     costMatrix.setCost(i, j, 0);
             }
         }

         return costMatrix;
     }

     private Node createStartNode(){
        return new Node();
     }

     private List<Node> buildNodes(){
         List<Node> ns = new ArrayList<>();
         ns.add(this.createStartNode());

         for(Order o : orders) {
             for(Requirement r : o.getProductslist()) {
                 ns.add(new Node(o, r));
             }
         }

         for(Node n : ns){
             if(!n.getStartNode())
                n.calculateProdTime();
         }

         return ns;
     }

     public OptimizationProblem buildOptimizationProblem(){
         return new OptimizationProblem(this.buildNodes(), this.buildMatrix());
     }
}
