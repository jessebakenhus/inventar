package us.bakenh.inventar.funktion;

import java.util.Scanner;

public interface InventarFunktion {

    void ausfuehren();

    default void print(String string) {
        System.out.println(string);
    }

    default String input(String prompt, Scanner scanner) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    default Number inputNumber(String prompt, Scanner scanner) {

        System.out.print(prompt);
        String string = scanner.nextLine().trim();

        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Ungültige Eingabe! Bitte eine Zahl eingeben.", e);
        }
    }
}
