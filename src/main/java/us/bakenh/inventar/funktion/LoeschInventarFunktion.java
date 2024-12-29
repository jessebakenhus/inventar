package us.bakenh.inventar.funktion;

import us.bakenh.inventar.domain.model.InventarEintrag;
import us.bakenh.inventar.presentation.IOBase;
import us.bakenh.inventar.persistence.InventarDao;

public class LoeschInventarFunktion implements InventarFunktion {

    private final InventarDao inventarDao;

    private final IOBase io;

    public LoeschInventarFunktion(InventarDao inventarDao, IOBase ioBase) {
        this.inventarDao = inventarDao;
        this.io = ioBase;
    }

    @Override
    public void ausfuehren() {

        io.print("\nEintrag löschen gewählt.");
        if (inventarDao.getAllEintraege().isEmpty()) {
            io.print("Keine Einträge zum Löschen.");
            return;
        }

        io.print("Aktuelle Einträge:");

        for (int i = 0; i < inventarDao.getAllEintraege().size(); i++) {
            io.print(i + 1 + ": " + inventarDao.getEintragByIndex(i));
        }

        int index = io.inputNumber("Nummer des zu löschenden Eintrags: ") - 1;

        if (index >= 0 && index < inventarDao.getAllEintraege().size()) {
            InventarEintrag entfernt = inventarDao.deleteEintragByIndex(index);
            io.print("Eintrag entfernt: " + entfernt);
        } else {
            io.print("Ungültige Nummer.");
        }
    }
}
