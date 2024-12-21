package us.bakenh.inventar.funktion;

import us.bakenh.inventar.domain.model.InventarEintrag;
import us.bakenh.inventar.persistence.InventarDao;

import java.util.List;
import java.util.Scanner;

public class LoeschInventarFunktion implements InventarFunktion {

    private final InventarDao inventarDao;

    private final Scanner scanner;

    public LoeschInventarFunktion(InventarDao inventarDao, Scanner scanner) {
        this.inventarDao = inventarDao;
        this.scanner = scanner;
    }

    @Override
    public void ausfuehren() {

        print("\nEintrag löschen gewählt.");
        if (inventarDao.getAllEintraege().isEmpty()) {
            print("Keine Einträge zum Löschen.");
            return;
        }

        print("Aktuelle Einträge:");

        for (int i = 0; i < inventarDao.getAllEintraege().size(); i++) {
            print(i + 1 + ": " + inventarDao.getEintragByIndex(i));
        }

        int index = inputNumber("Nummer des zu löschenden Eintrags: ", scanner).intValue() - 1;

        if (index >= 0 && index < inventarDao.getAllEintraege().size()) {
            InventarEintrag entfernt = inventarDao.deleteEintragByIndex(index);
            print("Eintrag entfernt: " + entfernt);
        } else {
            print("Ungültige Nummer.");
        }
    }
}
