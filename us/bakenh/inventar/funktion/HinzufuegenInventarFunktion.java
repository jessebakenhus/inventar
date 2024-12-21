package us.bakenh.inventar.funktion;

import us.bakenh.inventar.domain.model.InventarEintrag;
import us.bakenh.inventar.persistence.InventarDao;

import java.util.Scanner;

public class HinzufuegenInventarFunktion implements InventarFunktion {

    private final InventarDao inventarDao;

    private final Scanner scanner;

    public HinzufuegenInventarFunktion(InventarDao inventarDao, Scanner scanner) {
        this.inventarDao = inventarDao;
        this.scanner = scanner;
    }


    @Override
    public void ausfuehren() {

        print("\nEintrag hinzufügen gewählt.");

        String bezeichnung = input("Gegenstands-Bezeichnung: ", scanner);
        Number anzahl = inputNumber("Gegenstands-Anzahl: ", scanner);

        inventarDao.createEintrag(new InventarEintrag(bezeichnung, anzahl.intValue()));

        print("Eintrag hinzugefügt: " + bezeichnung + " (" + anzahl + ")");
    }
}
