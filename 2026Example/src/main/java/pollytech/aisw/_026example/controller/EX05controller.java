package pollytech.aisw._026example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/home")
public class EX05Controller {
    @GetMapping("/exam05")
    public String requestMethod(){
        return "view05";
    }

}
