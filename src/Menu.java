public class Menu {

    private  final Controller controller;

    public Menu(Controller controller) {
        this.controller = controller;
    }

    public void Display(){
        System.out.println("Menu");
        System.out.println("Benvenuto, vuoi: ");
        System.out.println("1. Creare un type");
    }
}
