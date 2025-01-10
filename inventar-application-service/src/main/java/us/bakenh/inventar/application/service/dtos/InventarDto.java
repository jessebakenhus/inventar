package us.bakenh.inventar.application.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class InventarDto {

    private final Integer id;

    private final Collection<InventarEintragDto> entries;

    public InventarDto(int id, Collection<InventarEintragDto> entries) {
        this.id = id;

        if (entries == null)
            this.entries = new ArrayList<>();
        else
            this.entries = entries;
    }
}
