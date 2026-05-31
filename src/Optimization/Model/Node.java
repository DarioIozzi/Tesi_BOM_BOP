package Optimization.Model;

import Operational.OrderManager.Order;
import Operational.Requirement;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Node {

    private int id;
    private final Order order;
    private final Requirement requirement;
    private long deadline;
    private final long productionTime;

    Node(Order order, Requirement requirement) {
        this.order = order;
        this.requirement = requirement;
        dateToLong();
        productionTime = calculateProdTime() * requirement.getQuantity();
    }

    private long calculateProdTime(){
        long sum = 0;
        for(Requirement child : requirement.getProduct().getChildren()){
            sum += (long) child.getProduct().getType().getProcessType().getFeatureType("DUR-PROC").getUnitType("DUR").getUnitValue();
        }

        return sum;
    }

    private void dateToLong(){

        deadline = ChronoUnit.DAYS.between(LocalDate.now(), order.getDeadline());
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public long getDeadline() {
        return deadline;
    }

    public long getProductionTime() {
        return productionTime;
    }
}
