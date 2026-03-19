package View.Operational;

import View.Menu;

import java.io.IOException;

public class OrderMenu extends Menu {

    @Override
    public void Display() throws IOException {

        int scelta;
        String code;
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
            System.out.println("9. View the order");
            System.out.println("10. Close this order");
            System.out.println("11. Remove this order");
            System.out.println("0. Exit");

            scelta = inputInt();

            switch (scelta) {
                case 1:
                    code = getProductCode();
                    controller.addObservation(orderId, code, "/Observation.json");
                    break;

                case 2:
                    code = getProductCode();
                    System.out.println("Write the new status");
                    System.out.println("1. Complete");
                    System.out.println("2. Failed");
                    status = inputInt();
                    controller.modifyStatusProcess(orderId, code, status);
                    break;

                case 3:
                    System.out.println("Write resource id");
                    resourceId = inputInt();
                    System.out.println("Write resource family");
                    family = inputInt();
                    code = getProductCode();
                    controller.addResourceToProduct(orderId, code, resourceId, family);
                    break;

                case 4:
                    code = getProductCode();
                    controller.addFeature(orderId, code, "/Feature");
                    break;

                case 5:
                    code = getProductCode();
                    System.out.println("Write the observation id");
                    obsId = inputInt();
                    controller.removeObservation(orderId, code, obsId);
                    break;

                case 6:
                    code = getProductCode();
                    controller.removeResourceFromProduct(orderId, code);
                    break;

                case 7:
                    code = getProductCode();
                    System.out.println("Write the feature id");
                    featureId = inputInt();
                    controller.removeFeature(orderId, code, featureId);
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
                    break;

                case 11:
                    controller.removeOrder(orderId);

                case 0:
                    System.out.println("Uscita in corso...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }

    public String getProductCode(){
        System.out.println("Please write the product code");
        return scanner.nextLine();
    }
}
