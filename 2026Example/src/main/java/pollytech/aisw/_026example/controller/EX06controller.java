package pollytech.aisw._026example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EX06Controller {
//    @GetMapping("/exam06")
//    public String requestMethod(Model model){
//        model.addAttribute("title1", "Model ?�형?�습1");
//        model.addAttribute("title2", "문자?�값 ?�는 객체참조�??�달 가??);
//        return "viewPage";
//    }

    @GetMapping("/exam06")
    public String requestMethod(Model model){
        model.addAttribute("title1", "Model ?�형?�습1");
        model.addAttribute("title2", "문자?�값 ?�는 객체참조�??�달 가??);
        return "view06";
    }
}
