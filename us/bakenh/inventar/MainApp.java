package us.bakenh.inventar;

import us.bakenh.inventar.funktion.AuflistenInventarFunktion;
import us.bakenh.inventar.funktion.HinzufuegenInventarFunktion;
import us.bakenh.inventar.funktion.LoeschInventarFunktion;
import us.bakenh.inventar.persistence.InventarDao;
import us.bakenh.inventar.presentation.ConsoleIO;
import us.bakenh.inventar.presentation.IOBase;

import java.util.Scanner;

public class MainApp {


    public void start() {
        initializeApp();
    }

    private void initializeApp() {

        // DAO initialisieren
        InventarDao inventarDao = new InventarDao();

        // IO Base initialisieren
        IOBase io = initialisiereIOBase();

        io.print("\nT U T O R I A L");
        io.print("---------------\n");
        io.print("Funktionen:");
        io.print("1: Programm beenden (q)");
        io.print("2: Eintrag hinzufügen (a)");
        io.print("3: Einträge auflisten (r)");
        io.print("4: Eintrag löschen (d)");

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
