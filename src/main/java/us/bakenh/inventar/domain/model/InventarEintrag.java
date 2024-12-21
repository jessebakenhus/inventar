package us.bakenh.inventar.domain.model;

public class InventarEintrag {

    private String bezeichnung;

    private int anzahl;

    public InventarEintrag(String bezeichnung, int anzahl) {
        this.bezeichnung = bezeichnung;
        this.anzahl = anzahl;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    @Override
    public String toString() {
        return "InventarEintrag{"
                + "bezeichnung='" + bezeichnung + '\''
                + ", anzahl=" + anzahl +'}';
    }
}
