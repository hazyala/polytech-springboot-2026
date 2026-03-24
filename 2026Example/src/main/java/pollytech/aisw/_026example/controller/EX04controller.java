package pollytech.aisw._026example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/example04",method = RequestMethod.GET)
public class EX04controller {
    @RequestMapping
    public String requestMethod() {
        return "viewEX03";
    }

    @RequestMapping(value = "/example04", method = RequestMethod.GET)
    public String requestMethod2() {
        return "viewEX04";
    }
}