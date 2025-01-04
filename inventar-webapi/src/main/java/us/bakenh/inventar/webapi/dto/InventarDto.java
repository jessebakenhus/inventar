package us.bakenh.inventar.webapi.dto;

import lombok.Data;
import lombok.NonNull;

import java.util.Collection;

@Data
public class InventarDto {

    private final int id;

    @NonNull
    private final Collection<InventarEintragDto> entries;
}
