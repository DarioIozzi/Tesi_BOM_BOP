package Optimization.Cost;

import Knowledge.ProductType;
import Operational.OrderManager.Order;
import Operational.Requirement;

import java.util.ArrayList;
import java.util.List;

public class CostMatrixBuilder {

    private List<Order> orders;
    private List<Requirement> requirements;

     CostMatrixBuilder(List<Order> orders) {
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

     CostMatrix buildMatrix(){

         CostMatrix costMatrix = new CostMatrix(requirements.size());

         for(int i=0; i < requirements.size(); i++) {
             for (int j = 0; j <requirements.size(); j++) {
                 if(i != j)
                     costMatrix.setCost(i, j, costCalculate(requirements.get(i), requirements.get(j)));
                 else
                     costMatrix.setCost(i, j, 0);
             }
         }

         return costMatrix;
     }


     int costCalculate(Requirement r1, Requirement r2) {

         int cost = 0;

         if(r1.getQuantity() > r2.getQuantity())
             cost = r1.getProduct().getType().getNumberElements() * (r1.getQuantity() - r2.getQuantity());
         else
             cost = r2.getProduct().getType().getNumberElements() * (r2.getQuantity() - r1.getQuantity());

         cost += materialChange(r1.getProduct().getType(), r2.getProduct().getType()) * Math.abs(r1.getQuantity() - r2.getQuantity());
         return cost;
     }


     int materialChange(ProductType prod1, ProductType prod2) {

         return Math.abs(prod1.getNumberElements() - prod2.getNumberElements());
     }
}
