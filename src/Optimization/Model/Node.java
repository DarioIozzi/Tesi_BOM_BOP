package Optimization.Model;

import Operational.OrderManager.Order;
import Operational.Requirement;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Node {

    private Order order;
    private Requirement requirement;
    private long deadline;
    private long productionTime;
    private boolean startNode = false;

    public Node(Order order, Requirement requirement) {
        this.order = order;
        this.requirement = requirement;
        this.dateToLongMinutes();
    }

    public Node(){
        this.startNode = true;
        this.productionTime = 0;
        this.deadline = 1000000;
    }

    public void calculateProdTime(){
        long sum = 0;
        for(Requirement child : requirement.getProduct().getChildren()){
            if(child.getProduct().getType().getProcessType().getFeatureType("DUR-PROC") == null){
                System.err.println("Feature con codice 'DUR-PROC' mancante");
                sum += 0;
            }
            else if(child.getProduct().getType().getProcessType().getFeatureType("DUR-PROC").getUnitType("DUR") == null) {
                System.err.println("UnitType con codice 'DUR' mancante");
                sum += 0;
            }else if(child.getProduct().getType().getProcessType().getFeatureType("DUR-PROC").getUnitType("DUR").getUnitValue() == null){
                System.err.println("UnitValue con codice 'DUR' errato");
                sum += 0;
            }else{
                sum += (long) child.getProduct().getType().getProcessType().getFeatureType("DUR-PROC").getUnitType("DUR").getUnitValue();
            }
        }

        this.productionTime = sum * requirement.getQuantity();
    }

    private void dateToLongMinutes(){

        deadline = ChronoUnit.DAYS.between(LocalDate.now(), order.getDeadline()) * 24 * 60;
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

    public void setProductionTime(long productionTime){
        this.productionTime = productionTime;
    }

    public Order getOrder(){
        return order;
    }

    public boolean getStartNode() {
        return startNode;
    }
}
