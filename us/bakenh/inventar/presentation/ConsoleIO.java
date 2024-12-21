package us.bakenh.inventar.presentation;

import java.util.Scanner;

public class ConsoleIO implements IOBase {

    private final Scanner scanner;

    public ConsoleIO() {

        this.scanner = new Scanner(System.in);

        print("\nT U T O R I A L");
        print("---------------\n");
        print("Funktionen:");
        print("1: Programm beenden (q)");
        print("2: Eintrag hinzufügen (a)");
        print("3: Einträge auflisten (r)");
        print("4: Eintrag löschen (d)");
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
