package pollytech.aisw._026example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EX08Controller {
    @GetMapping("/exam08")
    public ModelAndView requestMethod(){
        ModelAndView modelView = new ModelAndView();
        modelView.addObject("title1", "ModelAndView ?°ìŠµ");
        modelView.addObject("title2", "ModelAndView??addObject()?€ setViewName()ë¥??¬ìš©");
        modelView.setViewName("viewPage");
        return modelView;
    }
}
