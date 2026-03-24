package pollytech.aisw._026example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/example03",method = RequestMethod.GET)
public class EX03controller {
    @RequestMapping
    public String requestMethod() {
        return "viewEX03";
    }
}