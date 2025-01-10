package us.bakenh.inventar.application.service.dtos;

import lombok.Data;
import lombok.NonNull;

@Data
public class InventarEintragDto {

    private final Integer id;

    @NonNull
    private final String name;

    @NonNull
    private final Integer count;
}
