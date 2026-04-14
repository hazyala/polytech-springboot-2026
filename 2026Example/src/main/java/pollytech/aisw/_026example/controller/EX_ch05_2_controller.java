package pollytech.aisw._026example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Calendar;

public class EX_ch05_2_controller {
    @GetMapping("/chap0502/{name}/{birthyear}")
    public String requestMethod(@PathVariable("name") String name, @PathVariable("birthyear") int birthYear , Model model){
        Calendar calendar = Calendar.getInstance();
        int nowYear = calendar.get(Calendar.YEAR);
        int age = nowYear - birthYear;

        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return "viewPage05_02";
    }
}
