package us.bakenh.inventar;

import us.bakenh.inventar.persistence.DatabaseInventarDao;
import us.bakenh.inventar.domain.model.ConfigModel;
import us.bakenh.inventar.funktion.AuflistenInventarFunktion;
import us.bakenh.inventar.funktion.HinzufuegenInventarFunktion;
import us.bakenh.inventar.funktion.LoeschInventarFunktion;
import us.bakenh.inventar.persistence.InventarDao;
import us.bakenh.inventar.presentation.ConsoleIO;
import us.bakenh.inventar.presentation.IOBase;

public class MainApp {


    public void start(ConfigModel configModel) {
        initializeApp(configModel);
    }

    private void initializeApp(ConfigModel configModel) {

        // DAO initialisieren
        InventarDao inventarDao = new DatabaseInventarDao(configModel.getDatabase());

        // IO Base initialisieren
        IOBase io = initialisiereIOBase();

        while (true) {

            String funktion = io.input("\nWähle eine Funktion: ");

            switch (funktion) {
                case "q":

                    io.print("\nProgramm wird beendet.");
                    return;

                case "a":
                    new HinzufuegenInventarFunktion(inventarDao, io).ausfuehren();
                    break;

                case "r":
                    new AuflistenInventarFunktion(inventarDao).ausfuehren();
                    break;

                case "d":
                    new LoeschInventarFunktion(inventarDao, io).ausfuehren();
                    break;

                default:
                    io.print("Ungültige Auswahl! Bitte erneut versuchen.");
                    break;
            }
        }
    }

    private IOBase initialisiereIOBase() {
        return new ConsoleIO();
    }
}
