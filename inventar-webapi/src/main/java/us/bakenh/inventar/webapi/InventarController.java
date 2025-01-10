package us.bakenh.inventar.webapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import us.bakenh.inventar.application.service.InventarService;
import us.bakenh.inventar.application.service.dtos.InventarDto;

import java.util.List;

@RestController
public class InventarController {

    @Autowired
    private InventarService inventarService;

    @GetMapping(path = ApiPaths.API_LEVEL_1 + ApiPaths.INVENTAR)
    public List<InventarDto> findAllInventarDtos() {
        return inventarService.findAllInventare();
    }

    @PostMapping(path = ApiPaths.API_LEVEL_1 + ApiPaths.INVENTAR)
    public InventarDto createInventar(InventarDto inventarDto) {
        return inventarService.createInventar(inventarDto);
    }
}
