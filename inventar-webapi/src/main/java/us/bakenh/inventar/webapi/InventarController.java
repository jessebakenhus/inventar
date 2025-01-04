package us.bakenh.inventar.webapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import us.bakenh.inventar.webapi.dto.InventarDto;
import us.bakenh.inventar.webapi.dto.InventarEintragDto;

import java.util.Collection;
import java.util.List;

@Controller
@RestController
public class InventarController {

    @GetMapping(path = ApiPaths.API_LEVEL_1 + ApiPaths.INVENTAR)
    public Collection<InventarDto> findAllInventarDtos() {

        InventarEintragDto dummyEintragDto = new InventarEintragDto(1, "Apple MacBook Pro - M1 Pro - 2021", 1);

        return List.of(new InventarDto(1, List.of(dummyEintragDto)));
    }

}
