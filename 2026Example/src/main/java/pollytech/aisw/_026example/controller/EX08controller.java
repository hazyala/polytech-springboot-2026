package pollytech.aisw._026example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EX08controller {
    @GetMapping(value = "/example08")
    public ModelAndView requestMethod(){
        ModelAndView modelView = new ModelAndView();
        modelView.addObject("model1","ModelView 연습");
        modelView.addObject("model2","ModelAndView는 addObject()와 setViewName()을 사용");
        modelView.setViewName("viewEX08");
        return modelView;
    }
}
