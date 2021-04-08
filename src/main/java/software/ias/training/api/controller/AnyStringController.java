package software.ias.training.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/string")
public class AnyStringController {

    @GetMapping("/sub")
    public String stringHandler() {
        return "Any string";
    }

}
