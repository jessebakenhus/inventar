package us.bakenh.inventar.funktion;

import us.bakenh.inventar.InventarEintrag;

import java.util.List;
import java.util.Scanner;

public class HinzufuegenInventarFunktion implements InventarFunktion {


    private final List<InventarEintrag> eintraege;

    private final Scanner scanner;

    public HinzufuegenInventarFunktion(List<InventarEintrag> eintraege, Scanner scanner) {
        this.eintraege = eintraege;
        this.scanner = scanner;
    }

    @Override
    public void ausfuehren() {

        print("\nEintrag hinzufügen gewählt.");

        String bezeichnung = input("Gegenstands-Bezeichnung: ", scanner);
        Number anzahl = inputNumber("Gegenstands-Anzahl: ", scanner);

        eintraege.add(new InventarEintrag(bezeichnung, anzahl.intValue()));

        print("Eintrag hinzugefügt: " + bezeichnung + " (" + anzahl + ")");
    }
}
