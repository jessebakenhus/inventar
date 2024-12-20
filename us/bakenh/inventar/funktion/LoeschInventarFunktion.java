package us.bakenh.inventar.funktion;

import us.bakenh.inventar.InventarEintrag;

import java.util.List;
import java.util.Scanner;

public class LoeschInventarFunktion implements InventarFunktion {

    private final Scanner scanner;

    private final List<InventarEintrag> eintraege;

    public LoeschInventarFunktion(Scanner scanner, List<InventarEintrag> eintraege) {
        this.scanner = scanner;
        this.eintraege = eintraege;
    }

    @Override
    public void ausfuehren() {

        print("\nEintrag löschen gewählt.");
        if (eintraege.isEmpty()) {
            print("Keine Einträge zum Löschen.");
            return;
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
    }
}
