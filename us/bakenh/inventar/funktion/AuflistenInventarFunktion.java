package us.bakenh.inventar.funktion;

import us.bakenh.inventar.domain.model.InventarEintrag;
import us.bakenh.inventar.persistence.InventarDao;

import java.util.List;
import java.util.Scanner;

public class AuflistenInventarFunktion implements InventarFunktion {

    private final InventarDao inventarDao;

    private final Scanner scanner;

    public AuflistenInventarFunktion(InventarDao inventarDao, Scanner scanner) {
        this.inventarDao = inventarDao;
        this.scanner = scanner;
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
