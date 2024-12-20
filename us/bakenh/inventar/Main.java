package us.bakenh.inventar;

import us.bakenh.inventar.funktion.AuflistenInventarFunktion;
import us.bakenh.inventar.funktion.HinzufuegenInventarFunktion;
import us.bakenh.inventar.funktion.LoeschInventarFunktion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<InventarEintrag> eintraege = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        print("\nT U T O R I A L");
        print("---------------\n");
        print("Funktionen:");
        print("1: Programm beenden (q)");
        print("2: Eintrag hinzufügen (a)");
        print("3: Einträge auflisten (r)");
        print("4: Eintrag löschen (d)");

        while (true) {
            String funktion = input("\nWähle eine Funktion: ", scanner);

            switch (funktion) {
                case "q":

                    print("\nProgramm wird beendet.");
                    scanner.close();
                    return;

                case "a":
                    new HinzufuegenInventarFunktion(eintraege, scanner).ausfuehren();
                    break;

                case "r":
                    new AuflistenInventarFunktion(scanner, eintraege).ausfuehren();
                    break;

                case "d":
                    new LoeschInventarFunktion(scanner, eintraege).ausfuehren();
                    break;

                default:
                    print("Ungültige Auswahl! Bitte erneut versuchen.");
                    break;
            }
        }
    }

    private static void print(String string) {
        System.out.println(string);
    }

    private static String input(String prompt, Scanner scanner) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static Number inputNumber(String prompt, Scanner scanner) {

        System.out.print(prompt);
        String string = scanner.nextLine().trim();

        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Ungültige Eingabe! Bitte eine Zahl eingeben.", e);
        }
    }
}