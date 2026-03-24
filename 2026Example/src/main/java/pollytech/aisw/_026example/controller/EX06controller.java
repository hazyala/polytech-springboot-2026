package pollytech.aisw._026example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EX06controller {
    @GetMapping("/example06")
    public String requestMethod(Model model){
        model.addAttribute("title1","Model 유형 연습 중");
        model.addAttribute("title2","문자열 EX06controller값 참조 가능");
        return "viewEX06";
    }
}
