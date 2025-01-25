package us.bakenh.inventar.webapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.bakenh.inventar.application.service.InventarService;
import us.bakenh.inventar.persistence.entity.InventarEintragEntity;
import us.bakenh.inventar.persistence.entity.InventarEntity;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.API_LEVEL_1)
public class InventarController {

    @Autowired
    private InventarService inventarService;

    @PostMapping(path = ApiPaths.INVENTAR)
    public ResponseEntity<InventarEntity> createInventar(@RequestBody InventarEntity inventarEntity) {
        return ResponseEntity.ok(inventarService.createInventar(inventarEntity));
    }

    @GetMapping(path = ApiPaths.INVENTAR)
    public ResponseEntity<List<InventarEntity>> readAllInventare() {
        return ResponseEntity.ok(inventarService.readAllInventare());
    }

    @GetMapping(path = ApiPaths.INVENTAR + ApiPaths.BY_ID)
    public ResponseEntity<InventarEntity> readInventarById(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(inventarService.readInventarById(id));
    }

    @PutMapping(path = ApiPaths.INVENTAR + ApiPaths.BY_ID)
    public ResponseEntity<InventarEntity> updateInventar(
            @PathVariable(name = "id") Integer id,
            @RequestBody InventarEntity updatedInventar) {
        return ResponseEntity.ok(inventarService.updateInventar(id, updatedInventar));
    }

    @DeleteMapping(path = ApiPaths.INVENTAR + ApiPaths.BY_ID)
    public ResponseEntity<Void> deleteInventar(@PathVariable(name = "id") Integer id) {

        inventarService.deleteInventar(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = ApiPaths.INVENTAR + ApiPaths.BY_ID + ApiPaths.ENTRY)
    public ResponseEntity<List<InventarEintragEntity>> readInventoryEntries(@PathVariable(name = "id") Integer inventarId) {
        return ResponseEntity.ok(inventarService.readInventoryEntries(inventarId));
    }

    @GetMapping(path = ApiPaths.INVENTAR + ApiPaths.BY_ID + ApiPaths.ENTRY + ApiPaths.BY_ENTRY_ID)
    public ResponseEntity<InventarEintragEntity> readInventarEntryById(
            @PathVariable(name = "id") Integer inventarId,
            @PathVariable(name = "entry_id") Integer inventarEntryId) {

        InventarEintragEntity entry = inventarService.readInventarEntryById(inventarId, inventarEntryId);

        return ResponseEntity.ok(entry);
    }

    @PostMapping(path = ApiPaths.INVENTAR + ApiPaths.BY_ID + ApiPaths.ENTRY)
    public ResponseEntity<InventarEntity> addInventoryEntry(
            @PathVariable(name = "id") Integer inventarId,
            @RequestBody InventarEintragEntity newEntry) {

        InventarEntity updatedInventar = inventarService.addInventoryEntry(inventarId, newEntry);

        return ResponseEntity.ok(updatedInventar);
    }

    @PutMapping(path = ApiPaths.INVENTAR + ApiPaths.BY_ID + ApiPaths.ENTRY + ApiPaths.BY_ENTRY_ID)
    public ResponseEntity<InventarEntity> updateInventoryEntry(
            @PathVariable(name = "id") Integer inventarId,
            @PathVariable(name = "entry_id") Integer inventarEntryId,
            @RequestBody InventarEintragEntity updatedEntry) {

        InventarEntity updatedInventar = inventarService.updateInventoryEntry(inventarId, inventarEntryId, updatedEntry);

        return ResponseEntity.ok(updatedInventar);
    }

    @DeleteMapping(path = ApiPaths.INVENTAR + ApiPaths.BY_ID + ApiPaths.ENTRY + ApiPaths.BY_ENTRY_ID)
    public ResponseEntity<Void> deleteInventoryEntry(
            @PathVariable(name = "id") Integer inventarId,
            @PathVariable(name = "entry_id") Integer inventarEntryId) {

        inventarService.deleteInventoryEntry(inventarId, inventarEntryId);

        return ResponseEntity.noContent().build();
    }
}