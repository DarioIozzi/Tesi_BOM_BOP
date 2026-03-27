package View;

import Controller.Controller;

import java.io.IOException;
import java.util.Scanner;

public abstract class Menu {

    protected final Controller controller;
    protected final Scanner scanner;

    public Menu() {
        this.controller = Controller.getInstance();
        this.scanner = new Scanner(System.in);
    }

    public abstract void display() throws IOException;

    protected int inputInt() {
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
