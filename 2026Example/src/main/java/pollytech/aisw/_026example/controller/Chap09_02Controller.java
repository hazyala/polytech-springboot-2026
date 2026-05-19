package pollytech.aisw._026example.controller;

import jakarta.validation.Valid;
import pollytech.aisw._026example.domain.Member2;
import pollytech.aisw._026example.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam09_02")
public class Chap09_02Controller {
    @GetMapping
    public String showForm(Model model){
        model.addAttribute("member2", new Member2());
        return "viewPage09_02";
    }

    @PostMapping
    public String submitForm(@Valid @ModelAttribute Member2 member2, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "viewPage09_02";
        }
        return "viewPage09_02_result";
    }
}
