package View;

import View.Knowledge.MenuProductCatalog;
import View.Operational.MenuWarehouse;
import View.Operational.OrderMenu;

import java.io.IOException;

public class MenuFacade extends Menu {

    private Menu menuAttuale;

    public MenuFacade() {
        super();
        menuAttuale = this;
    }

    @Override
    public void display() throws IOException {

        int scelta;

        while (true) {
            System.out.println("Menu");
            System.out.println("Welcome, do you want to: ");
            System.out.println("1. Manage product catalog");
            System.out.println("2. Manage an order");
            System.out.println("3. Manage the warehouse");
            System.out.println("4. View orders");
            System.out.println("5. Add an order");
            System.out.println("6. Remove an order");
            System.out.println("0. Exit");

            scelta = inputInt();

            switch (scelta) {
                case 1:
                    menuAttuale = new MenuProductCatalog();
                    menuAttuale.display();
                    break;

                case 2:
                    menuAttuale = new OrderMenu();
                    menuAttuale.display();
                    break;

                case 3:
                    menuAttuale = new MenuWarehouse();
                    menuAttuale.display();
                    break;

                case 4:
                    System.out.println(controller.getOrderList());
                    break;

                case 5:
                    controller.addOrder("/Order.json");
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
