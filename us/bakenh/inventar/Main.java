package us.bakenh.inventar;

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

                    print("\nEintrag hinzufügen gewählt.");

                    String bezeichnung = input("Gegenstands-Bezeichnung: ", scanner);
                    Number anzahl = inputNumber("Gegenstands-Anzahl: ", scanner);

                    eintraege.add(new InventarEintrag(bezeichnung, anzahl.intValue()));

                    print("Eintrag hinzugefügt: " + bezeichnung + " (" + anzahl + ")");

                    break;

                case "r":

                    print("\nEintrag auflisten gewählt.");
                    print("Aktuelle Einträge:");

                    for (int i = 0; i < eintraege.size(); i++) {
                        print(i + 1 + ": " + eintraege.get(i));
                    }

                    break;

                case "d":

                    print("\nEintrag löschen gewählt.");
                    if (eintraege.isEmpty()) {
                        print("Keine Einträge zum Löschen.");
                        break;
                    }

                    print("Aktuelle Einträge:");

                    for (int i = 0; i < eintraege.size(); i++) {
                        print(i + 1 + ": " + eintraege.get(i));
                    }

                    int index = inputNumber("Nummer des zu löschenden Eintrags: ", scanner).intValue() - 1;

                    if (index >= 0 && index < eintraege.size()) {
                        InventarEintrag entfernt = eintraege.remove(index);
                        print("Eintrag entfernt: " + entfernt);
                    } else {
                        print("Ungültige Nummer.");
                    }

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