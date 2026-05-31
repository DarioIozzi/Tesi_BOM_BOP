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

         List<ProductType> elements1 = new ArrayList<>(r1.getProduct().getType().getAllElement());
         List<ProductType> elements2 = new ArrayList<>(r2.getProduct().getType().getAllElement());

         for(ProductType el1 : elements1){
             if(elements2.contains(el1)){
                 if(r1.getQuantity() > r2.getQuantity())
                     cost += Math.abs(r1.getQuantity() - r2.getQuantity());        //tolgo elemento costo 1 ciascuno
                 else
                     cost = 2 * Math.abs(r1.getQuantity() - r2.getQuantity());     //aggiungo elemento costo 2 ciascuno
             }
         }

         for(ProductType el2 : elements2){
             if(!elements1.contains(el2)){
                 cost += 2 * Math.abs(r1.getQuantity() - r2.getQuantity());       //aggiungo elemento costo 2 ciascuno
             }
         }

         return cost;
     }
}
