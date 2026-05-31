package Optimization.Model;

import Operational.OrderManager.Order;
import Operational.Requirement;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Node {

    private int id;
    private Order order;
    private Requirement requirement;
    private long deadline;

    Node(Order order, Requirement requirement) {
        this.order = order;
        this.requirement = requirement;
        dateToLong();
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
}
