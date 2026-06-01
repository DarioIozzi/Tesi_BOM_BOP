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

         CostMatrix costMatrix = new CostMatrix(requirements.size());

         for(int i=0; i < requirements.size(); i++) {
             for (int j = 0; j <requirements.size(); j++) {
                 if(i != j)
                     costMatrix.setCost(i, j, transitCostCalculate(requirements.get(i), requirements.get(j)));
                 else
                     costMatrix.setCost(i, j, 0);
             }
         }

         return costMatrix;
     }

     private List<Node> buildNodes(){
         List<Node> ns = new ArrayList<>();

         for(Order o : orders) {
             for(Requirement r : o.getProductslist()) {
                 ns.add(new Node(o, r));
             }
         }
         return ns;
     }

     public OptimizationProblem buildOptimizationProblem(){
         return new OptimizationProblem(this.buildNodes(), this.buildMatrix());
     }
}
