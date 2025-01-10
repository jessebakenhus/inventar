package us.bakenh.inventar.application.service.converter;

import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;
import us.bakenh.inventar.persistence.entity.InventarEntity;
import us.bakenh.inventar.application.service.dtos.InventarDto;
import us.bakenh.inventar.application.service.dtos.InventarEintragDto;

import java.util.List;


@UtilityClass
public class InventarEntityConverter {

    public InventarDto fromEntityToDto(InventarEntity entity) {

        List<InventarEintragDto> dtos = entity.getInventarEintragEntities().stream()
                .map(InventarEintragEntityConverter::fromEntityToDto)
                .toList();

        return new InventarDto(entity.getId(), dtos);
    }
}
