package us.bakenh.inventar.funktion;

import us.bakenh.inventar.domain.model.InventarEintrag;
import us.bakenh.inventar.presentation.IOBase;
import us.bakenh.inventar.persistence.InventarDao;

public class HinzufuegenInventarFunktion implements InventarFunktion {

    private final InventarDao inventarDao;

    private final IOBase io;

    public HinzufuegenInventarFunktion(InventarDao inventarDao, IOBase io) {
        this.inventarDao = inventarDao;
        this.io = io;
    }


    @Override
    public void ausfuehren() {

        io.print("\nEintrag hinzufügen gewählt.");

        String bezeichnung = io.input("Gegenstands-Bezeichnung: ");
        Number anzahl = io.inputNumber("Gegenstands-Anzahl: ");

        inventarDao.createEintrag(new InventarEintrag(bezeichnung, anzahl.intValue()));

        io.print("Eintrag hinzugefügt: " + bezeichnung + " (" + anzahl + ")");
    }
}
