package us.bakenh.inventar.persistence;

import us.bakenh.inventar.domain.model.InventarEintrag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventarDao {

    private final List<InventarEintrag> eintraege = new ArrayList<>();

    public void createEintrag(InventarEintrag inventarEintrag) {
        eintraege.add(inventarEintrag);
    }

    public InventarEintrag getEintragByIndex(int index) {
        return eintraege.get(index);
    }

    public void deleteEintrag(InventarEintrag inventarEintrag) {
        eintraege.remove(inventarEintrag);
    }

    public InventarEintrag deleteEintragByIndex(int index) {
        return eintraege.remove(index);
    }

    public List<InventarEintrag> getAllEintraege() {
        return Collections.unmodifiableList(eintraege);
    }
}
