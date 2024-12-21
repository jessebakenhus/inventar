package us.bakenh.inventar.presentation;

import java.util.Scanner;

public class ConsoleIO implements IOBase {

    private final Scanner scanner;

    public ConsoleIO() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String input() {
        return scanner.nextLine().trim();
    }

    @Override
    public String input(String prompt) {
        System.out.print(prompt);
        return input();
    }

    @Override
    public int inputNumber() {

        String string = scanner.nextLine().trim();

        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Ungültige Eingabe! Bitte eine Zahl eingeben.", e);
        }
    }

    @Override
    public int inputNumber(String prompt) {
        System.out.print(prompt);
        return inputNumber();
    }

    @Override
    public void print(String string) {
        System.out.println(string);
    }
}
