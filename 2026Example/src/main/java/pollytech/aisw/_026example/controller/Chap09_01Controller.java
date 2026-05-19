package pollytech.aisw._026example.controller;

import jakarta.validation.Valid;
import pollytech.aisw._026example.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam09_01")
public class Chap09_01Controller {
    @GetMapping
    public String showForm(Model model){
        model.addAttribute("product", new Product());
        return "viewPage09_01";
    }

    @PostMapping
    public String submitForm(@Valid @ModelAttribute Product product, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "viewPage09_01";
        }
        return "viewPage09_01_result";
    }
}
