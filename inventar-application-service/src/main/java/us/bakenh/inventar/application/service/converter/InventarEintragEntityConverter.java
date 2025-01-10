package us.bakenh.inventar.application.service.converter;

import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;
import us.bakenh.inventar.persistence.entity.InventarEintragEntity;
import us.bakenh.inventar.application.service.dtos.InventarEintragDto;

@UtilityClass
public class InventarEintragEntityConverter {

    public InventarEintragDto fromEntityToDto(InventarEintragEntity eintragEntity) {
        return new InventarEintragDto(eintragEntity.getId(), eintragEntity.getBezeichnung(), eintragEntity.getAnzahl());
    }
}
