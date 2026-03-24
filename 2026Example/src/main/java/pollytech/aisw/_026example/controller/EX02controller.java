package pollytech.aisw._026example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EX02controller {
    @RequestMapping(value = "/example02",method = RequestMethod.GET)
    public String requestMethod(){
        return "<h1>@RestController 연습</h1>";
    }
}
