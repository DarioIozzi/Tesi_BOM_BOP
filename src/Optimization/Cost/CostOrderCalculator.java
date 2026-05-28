package Optimization.Cost;

import Operational.OrderManager.Order;

import java.util.ArrayList;
import java.util.List;

public class CostOrderCalculator {

    int calculateCostOrder(Order o){

        int cost = 0;
        List<Order> orders = new ArrayList<>();
        orders.add(o);
        CostMatrix cm = new CostMatrixBuilder(orders).buildMatrix();

        for(int i=0; i<orders.size(); i++){
            for(int j=i+1; j<orders.size(); j++) {
                cost += cm.getCost(i, j);
            }
        }

        return cost;            //si calcola il costo di una matrice triangolare, da modificare se non triangolare
    }
}
