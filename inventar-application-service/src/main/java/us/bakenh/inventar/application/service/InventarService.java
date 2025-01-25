package us.bakenh.inventar.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.bakenh.inventar.persistence.entity.InventarEintragEntity;
import us.bakenh.inventar.persistence.entity.InventarEntity;
import us.bakenh.inventar.persistence.repository.InventarJpaRepository;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@Service
public class InventarService {

    @Autowired
    private InventarJpaRepository inventarRepository;

    public InventarEntity createInventar(InventarEntity inventarEntity) {
        return inventarRepository.save(inventarEntity);
    }

    public List<InventarEntity> readAllInventare() {
        return inventarRepository.findAll();
    }

    public InventarEntity readInventarById(int id) {
        Optional<InventarEntity> inventarEntityOptional = inventarRepository.findById(id);
        return inventarEntityOptional.orElseThrow(() ->
                new IllegalStateException(MessageFormat.format("Inventar mit der ID:{0} nicht gefunden.", id)));
    }

    public InventarEntity updateInventar(int id, InventarEntity updatedInventar) {

        InventarEntity existingInventar = readInventarById(id);
        existingInventar.setEintraege(updatedInventar.getEintraege());

        return inventarRepository.save(existingInventar);
    }

    public void deleteInventar(int id) {

        if (!inventarRepository.existsById(id)) {
            throw new IllegalStateException(MessageFormat.format("Inventar mit der ID:{0} nicht gefunden.", id));
        }

        inventarRepository.deleteById(id);
    }

    public List<InventarEintragEntity> readInventoryEntries(int inventarId) {
        return readInventarById(inventarId).getEintraege();
    }

    public InventarEintragEntity readInventarEntryById(int inventarId, int inventarEntryId) {

        return readInventoryEntries(inventarId).stream()
                .filter(entry -> entry.getId().equals(inventarEntryId))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("Eintrag konnte nicht gefunden werden."));
    }

    public InventarEntity addInventoryEntry(int inventarId, InventarEintragEntity newEntry) {

        InventarEntity inventar = readInventarById(inventarId);

        newEntry.setInventar(inventar);
        inventar.getEintraege().add(newEntry);

        return inventarRepository.save(inventar);
    }

    public InventarEntity updateInventoryEntry(int inventarId, int inventarEntryId, InventarEintragEntity updatedEntry) {

        InventarEntity inventar = readInventarById(inventarId);
        InventarEintragEntity existingEntry = readInventarEntryById(inventarId, inventarEntryId);

        existingEntry.setBezeichnung(updatedEntry.getBezeichnung());
        existingEntry.setAnzahl(updatedEntry.getAnzahl());

        return inventarRepository.save(inventar);
    }

    public InventarEntity deleteInventoryEntry(int inventarId, int inventarEntryId) {

        InventarEntity inventar = readInventarById(inventarId);
        InventarEintragEntity entryToRemove = readInventarEntryById(inventarId, inventarEntryId);

        inventar.getEintraege().remove(entryToRemove);
        return inventarRepository.save(inventar);
    }
}