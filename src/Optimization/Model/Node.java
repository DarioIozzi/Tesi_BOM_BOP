package Optimization.Model;

import Operational.OrderManager.Order;
import Operational.Requirement;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Node {

    private Order order;
    private Requirement requirement;
    private long deadline;
    private final long productionTime;
    private boolean startNode = false;

    public Node(Order order, Requirement requirement) {
        this.order = order;
        this.requirement = requirement;
        this.dateToLong();
        productionTime = calculateProdTime() * requirement.getQuantity();
    }

    public Node(){
        this.startNode = true;
        this.productionTime = 0;
        this.deadline = 1000000;
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

    public void setDeadline(long deadline) {
        this.deadline = deadline;
    }

    public long getProductionTime() {
        return productionTime;
    }

    public Order getOrder(){
        return order;
    }
}
