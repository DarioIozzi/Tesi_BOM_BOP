package View.Knowledge;

import View.Menu;

import java.io.IOException;

public class MenuProductCatalog extends Menu {

    public MenuProductCatalog() {
        super();
    }

    @Override
    public void Display() throws IOException {
        int scelta;

        while (true) {
            System.out.println("Menu");
            System.out.println("Welcome, do you want to: ");
            System.out.println("1. Look at the product catalog");
            System.out.println("2. add a products");
            System.out.println("3. add a list of products");
            System.out.println("4. Remove a product");
            System.out.println("0. Exit");

            scelta = inputInt();

            switch (scelta) {
                case 1:
                    System.out.println(controller.displayProductCatalog());
                    break;

                case 2:
                    controller.addProductType();
                    break;

                case 3:
                    controller.addProductTypeList();
                    break;

                case 4:
                    System.out.println("Write product id");
                    int id = inputInt();
                    controller.removeProductType(id);
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
