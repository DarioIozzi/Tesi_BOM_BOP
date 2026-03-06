import java.io.IOException;
import java.util.Scanner;

public class Menu {

    private final Controller controller;
    private final Scanner scanner;

    public Menu(Controller controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void Display() throws IOException {

        int scelta;

        while (true) {
            System.out.println("Menu");
            System.out.println("Welcome, do you want to: ");
            System.out.println("1. Add a process type");
            System.out.println("2. Add an elementary product type");
            System.out.println("3. Add a resource type");
            System.out.println("4. Add a process");
            System.out.println("5. Add an elementary product");
            System.out.println("6. Add a resource");
            System.out.println("7. Add a unit");
            System.out.println("8. Add an order");
            System.out.println("0. Exit");

            scelta = inputInt();

            switch (scelta) {
                case 1:
                    controller.addProcessType();
                    break;

                case 2:
                    controller.addProductType();
                    break;

                case 3:
                    controller.addResourceType();
                    break;

                case 4:
                    controller.addProcess();
                    break;

                case 5:
                    controller.addElement();
                    break;

                case 6:
                    controller.addResource();
                    break;

                case 7:
                    controller.addUnit();
                    break;

                case 8:
                    controller.addOrder();
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

    private int inputInt() {
        String numeroStringa;
        int numero;
        numeroStringa = scanner.nextLine();
        try {
            numero = Integer.parseInt(numeroStringa); // caso numerico
        } catch (NumberFormatException e) {
            numero = -1;
        }
        return numero;
    }
}
