package us.bakenh.inventar.webapi.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class InventarEintragDto {

    private final int id;

    @NonNull
    private final String name;

    private final int count;
}
