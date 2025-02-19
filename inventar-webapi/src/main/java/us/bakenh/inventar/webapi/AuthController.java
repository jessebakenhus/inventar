package us.bakenh.inventar.webapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPaths.API_LEVEL_1 + ApiPaths.AUTH)
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "Pimmel";
    }
}
