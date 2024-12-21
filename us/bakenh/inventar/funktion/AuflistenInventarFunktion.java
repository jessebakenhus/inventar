package us.bakenh.inventar.funktion;

import us.bakenh.inventar.persistence.InventarDao;

public class AuflistenInventarFunktion implements InventarFunktion {

    private final InventarDao inventarDao;

    public AuflistenInventarFunktion(InventarDao inventarDao) {
        this.inventarDao = inventarDao;
    }

    @Override
    public void ausfuehren() {

        System.out.println("\nEintrag auflisten gewählt.") ;
        System.out.println("Aktuelle Einträge:");

        for (int i = 0; i < inventarDao.getAllEintraege().size(); i++) {
            System.out.println(i + 1 + ": " + inventarDao.getAllEintraege().size());
        }

    }
}
