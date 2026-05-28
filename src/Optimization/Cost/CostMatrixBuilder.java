package Optimization.Cost;

import Knowledge.ProductType;
import Operational.OrderManager.Order;

import java.util.ArrayList;
import java.util.List;

public class CostMatrixBuilder {

    private List<Order> orders;
    private List<ProductType> productTypes = new ArrayList<>();

     CostMatrixBuilder(List<Order> orders) {
         this.orders = new ArrayList<>(orders);

     }

     CostMatrix buildMatrix(){

         CostMatrix costMatrix = new CostMatrix(productTypes.size());

         for(int i=0; i<productTypes.size(); i++) {
             for (int j = 0; j <productTypes.size(); j++) {
                 if(i != j)
                     costMatrix.setCost(i, j, costCalculate(productTypes.get(i), productTypes.get(j)));
                 else
                     costMatrix.setCost(i, j, 0);
             }
         }

         return costMatrix;
     }


     int costCalculate(ProductType prod1, ProductType prod2) {

         int cost = 0;

         cost += materialChange(prod1, prod2);
         return cost;
     }


     int materialChange(ProductType prod1, ProductType prod2) {

         int diff = 0;

         return diff += Math.abs(prod1.getNumberElements() - prod2.getNumberElements());
     }
}
