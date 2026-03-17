package View.Operational;

import View.Menu;

import java.io.IOException;

public class MenuWarehouse extends Menu {


    @Override
    public void Display() throws IOException {

        int scelta;
        int family;
        int resourceId;

        while(true){
            System.out.println("Warehouse Menu");
            System.out.println("Welcome, choose an option");
            System.out.println("1. Add a resource");
            System.out.println("2. Remove a resource");
            System.out.println("3. View warehouse");
            System.out.println("0. Exit");

            scelta = inputInt();

            switch(scelta){
                case 1:
                    controller.addResourceToWarehouse();
                    break;

                case 2:
                    System.out.println("Write the resource family");
                    family = inputInt();
                    System.out.println("Write the id of the resource");
                    resourceId = inputInt();
                    controller.removeResourceFromWarehouse(family, resourceId);
                    break;

                case 3:
                    controller.displayWarehouse();
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
