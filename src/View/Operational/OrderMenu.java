package View.Operational;

import View.Menu;

import java.io.IOException;

public class OrderMenu extends Menu {

    @Override
    public void Display() throws IOException {

        int scelta;
        int productId;
        int orderId;
        int status;
        int resourceId;
        int family;
        int obsId;
        int featureId;

        while (true) {
            System.out.println("Order Menu");
            System.out.println("Please write the order id");

            orderId = inputInt();

            System.out.println("Do you want to: ");
            System.out.println("1. Add an observation");
            System.out.println("2. Manage process status");
            System.out.println("3. Add a resource to a basic element");
            System.out.println("4. Add a feature to a product");
            System.out.println("5. Remove an observation");
            System.out.println("6. Remove a resource from a basic element");
            System.out.println("7. Remove a feature from a product");
            System.out.println("8. Start an order");
            System.out.println("9. Look at an order");
            System.out.println("10. Close an order");
            System.out.println("0. Exit");

            scelta = inputInt();

            switch (scelta) {
                case 1:
                    productId = getProductId();
                    controller.addObservation(orderId, productId);
                    break;

                case 2:
                    productId = getProductId();
                    System.out.println("Write the new status");
                    System.out.println("1. Complete");
                    System.out.println("2. Failed");
                    status = inputInt();
                    controller.modifyStatusProcess(orderId, productId, status);
                    break;

                case 3:
                    System.out.println("Write resource id");
                    resourceId = inputInt();
                    System.out.println("Write resource family");
                    family = inputInt();
                    productId = getProductId();
                    controller.addResourceToProduct(orderId, productId, resourceId, family);
                    break;

                case 4:
                    productId = getProductId();
                    controller.addFeature(orderId, productId);
                    break;

                case 5:
                    productId = getProductId();
                    System.out.println("Write the observation id");
                    obsId = inputInt();
                    controller.removeObservation(orderId, productId, obsId);
                    break;

                case 6:
                    productId = getProductId();
                    controller.removeResourceFromProduct(orderId, productId);
                    break;

                case 7:
                    productId = getProductId();
                    System.out.println("Write the feature id");
                    featureId = inputInt();
                    controller.removeFeature(orderId, productId, featureId);
                    break;

                case 8:
                    controller.startOrder(orderId);
                    break;

                case 9:
                    controller.displayOrder(orderId);
                    break;

                case 10:
                    System.out.println("1.Completed");
                    System.out.println("2.Failed");
                    int res = inputInt();
                    controller.closeOrder(orderId, res);

                case 0:
                    System.out.println("Uscita in corso...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }

    public int getProductId(){
        System.out.println("Please write the product id");
        return inputInt();
    }
}
