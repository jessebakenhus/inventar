package us.bakenh.inventar.funktion;

import us.bakenh.inventar.InventarEintrag;

import java.util.List;
import java.util.Scanner;

public class AuflistenInventarFunktion implements InventarFunktion {

    private final Scanner scanner;

    private final List<InventarEintrag> eintraege;

    public AuflistenInventarFunktion(Scanner scanner, List<InventarEintrag> eintraege) {
        this.scanner = scanner;
        this.eintraege = eintraege;
    }

    @Override
    public void ausfuehren() {

        System.out.println("\nEintrag auflisten gewählt.") ;
        System.out.println("Aktuelle Einträge:");

        for (int i = 0; i < eintraege.size(); i++) {
            System.out.println(i + 1 + ": " + eintraege.get(i));
        }

    }
}
