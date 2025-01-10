package us.bakenh.inventar.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.bakenh.inventar.application.service.converter.InventarEntityConverter;
import us.bakenh.inventar.application.service.dtos.InventarDto;
import us.bakenh.inventar.persistence.entity.InventarEintragEntity;
import us.bakenh.inventar.persistence.entity.InventarEntity;
import us.bakenh.inventar.persistence.repository.InventarJpaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InventarService {

    @Autowired
    private InventarJpaRepository inventarRepository;

    public InventarDto findInventarById(int id) {

        Optional<InventarEntity> inventarEntityOptional = inventarRepository.findById(id);

        InventarEntity inventarEntity = inventarEntityOptional.orElseThrow(() ->
                new IllegalStateException("Entity konnte nicht in Dto konvertiert werden."));

        return InventarEntityConverter.fromEntityToDto(inventarEntity);
    }

    public List<InventarDto> findAllInventare() {
        return inventarRepository.findAll().stream()
                .map(InventarEntityConverter::fromEntityToDto)
                .toList();
    }

    public InventarDto createInventar(InventarDto inventarDto) {

        List<InventarEintragEntity> entries = inventarDto.getEntries().stream()
                .map(eintrag -> {

                    InventarEintragEntity inventarEintragEntity = new InventarEintragEntity();

                    inventarEintragEntity.setBezeichnung(eintrag.getName());
                    inventarEintragEntity.setAnzahl(eintrag.getCount());

                    return inventarEintragEntity;
                })
                .toList();

        InventarEntity entity = new InventarEntity();

        entity.setInventarEintragEntities(entries);

        return InventarEntityConverter.fromEntityToDto(inventarRepository.save(entity));
    }
}
