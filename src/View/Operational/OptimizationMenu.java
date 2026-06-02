package View.Operational;

import View.Menu;

public class OptimizationMenu extends Menu {

    @Override
    public void display(){

        int scelta;
        int days;

        while(true) {

            System.out.println("Optimization Menu");
            System.out.println("1. To optimize");
            System.out.println("0. Exit");

            scelta = inputInt();

            switch (scelta) {

                case 1:
                    System.out.println("Enter the maximum number of days remaining until an order's deadline.");
                    days = inputInt();
                    controller.optimize(days);
                    break;

                case 0:
                    System.out.println("Uscita in corso...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }
}
