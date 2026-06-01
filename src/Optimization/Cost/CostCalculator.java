package Optimization.Cost;

import Knowledge.ProductType;
import Operational.Requirement;

import java.util.ArrayList;
import java.util.List;

public class CostCalculator {

    /*int calculateCostOrder(Order o){

        int cost = 0;
        List<Order> orders = new ArrayList<>();
        orders.add(o);
        CostMatrix cm = new OptimizationProblemBuilder(orders).buildMatrix();

        for(int i=0; i<orders.size(); i++){
            for(int j=i+1; j<orders.size(); j++) {
                cost += cm.getCost(i, j);
            }
        }

        return cost;            //si calcola il costo di una matrice triangolare, da modificare se non triangolare
    }*/

    public static int transitCostCalculate(Requirement r1, Requirement r2) {

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
