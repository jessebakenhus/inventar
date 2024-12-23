package us.bakenh.inventar.funktion;

import us.bakenh.inventar.domain.model.InventarEintrag;
import us.bakenh.inventar.persistence.InventarDao;

public class AuflistenInventarFunktion implements InventarFunktion {

    private final InventarDao inventarDao;

    public AuflistenInventarFunktion(InventarDao inventarDao) {
        this.inventarDao = inventarDao;
    }

    @Override
    public void ausfuehren() {

        System.out.println("\nEintrag auflisten gewählt.") ;
        System.out.println("\nAktuelle Einträge:");

        int index = 1;

        for (InventarEintrag inventarEintrag : inventarDao.getAllEintraege()) {

            System.out.printf("%s. %s - %sx%n", index, inventarEintrag.getBezeichnung(), inventarEintrag.getAnzahl());
            index++;
        }
    }
}
