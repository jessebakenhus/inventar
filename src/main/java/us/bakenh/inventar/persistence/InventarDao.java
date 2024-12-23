package us.bakenh.inventar.persistence;

import us.bakenh.inventar.domain.model.InventarEintrag;

import java.util.List;

public interface InventarDao {

    void createEintrag(InventarEintrag inventarEintrag);

    InventarEintrag getEintragByIndex(int index);

    void deleteEintrag(InventarEintrag inventarEintrag);

    InventarEintrag deleteEintragByIndex(int index);

    List<InventarEintrag> getAllEintraege();
}
