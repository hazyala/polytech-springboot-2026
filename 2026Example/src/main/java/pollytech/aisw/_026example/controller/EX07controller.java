package pollytech.aisw._026example.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EX07controller {
    @GetMapping("/example07")
    public String requestMethod(Model model){
        model.addAttribute("data1","Model 유형 연습 중");
        model.addAttribute("data2","문자열 EX07controller값 참조 가능");
        return "viewEX07";
    }
}
