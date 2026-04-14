package pollytech.aisw._026example.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pollytech.aisw._026example.domain.Member;

@Controller
public class EX09controller {
    @GetMapping("/member")
    public String requestForm(){
        return "signUp";
    }

    @PostMapping("/member")
    public String requestFormResult(/* 생략가능 @ModelAttribute*/ Member member, Model model){
//        model.addAttribute("member", member); //생략가능
        return "signUpResult";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
//        binder.setAllowedFields("id", "city", "hobby");
        binder.setDisallowedFields("passwd", "city");
    }
}
