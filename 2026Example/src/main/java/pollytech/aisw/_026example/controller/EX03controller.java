package pollytech.aisw._026example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping(value = "/exam03", method = RequestMethod.GET)
public class EX03Controller {
//    @RequestMapping
    @RequestMapping(value = "/exam03", method = RequestMethod.GET)
    public String requestMethod(){
        return "view03";
    }

    @RequestMapping(value = "/exam03_1", method = RequestMethod.GET)
    public String requestMethod2(){
        return "view04";
    }
}
