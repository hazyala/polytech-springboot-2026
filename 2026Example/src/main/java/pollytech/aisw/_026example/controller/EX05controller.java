package pollytech.aisw._026example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/example05")
public class EX05controller {
    @GetMapping(value = "/example05")
    public String requestMethod() {
        return "viewEX05";
    }
}