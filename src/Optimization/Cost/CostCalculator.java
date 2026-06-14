package Optimization.Cost;

import Knowledge.RequirementType;
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

        List<RequirementType> elements1 = new ArrayList<>(r1.getProduct().getType().getAllElement());
        List<RequirementType> elements2 = new ArrayList<>(r2.getProduct().getType().getAllElement());

        for(RequirementType el1 : elements1){
            boolean found = false;
            for(RequirementType el2 : elements2){
                if(el1.getProductType().getCode().equals(el2.getProductType().getCode())){

                    found = true;
                    if(r1.getQuantity() * el1.getQuantity() > r2.getQuantity() * el2.getQuantity())
                        cost += Math.abs(r1.getQuantity() * el1.getQuantity() - r2.getQuantity() * el2.getQuantity());        //tolgo elemento, costo 1 ciascuno
                    else
                        cost += 2 * Math.abs(r1.getQuantity() * el1.getQuantity() - r2.getQuantity() * el2.getQuantity());     //aggiungo elemento, costo 2 ciascuno
                }
            }
            if(!found)
                cost += Math.abs(r1.getQuantity() * el1.getQuantity());
        }

        for(RequirementType el2 : elements2){

            boolean found = false;
            for(RequirementType el1 : elements1){

                if(el2.getProductType().getCode().equals(el1.getProductType().getCode())) {
                    found = true;
                }
            }

            if (!found){

                cost += 2 * r2.getQuantity() * el2.getQuantity();       //aggiungo elemento, costo 2 ciascuno
            }
        }

        return cost;
    }
}
