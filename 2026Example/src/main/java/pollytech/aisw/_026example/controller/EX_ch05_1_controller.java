package pollytech.aisw._026example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public class EX_ch05_1_controller {
    @GetMapping("/chap0501")
    public String requestMethod(@RequestParam("id") String userId, @RequestParam("pwd") String userPwd,  Model model){
        model.addAttribute("userId", userId);
        model.addAttribute("userPwd", userPwd);
        return "viewPage05_01";
    }

    @GetMapping("/chap0502")
    public String requestMethod2(@RequestParam(value = "id", defaultValue = "관리자") String userId, @RequestParam("pwd") String userPwd,  Model model){
        model.addAttribute("userId", userId);
        model.addAttribute("userPwd", userPwd);
        return "viewPage05_01";
    }

    @GetMapping("/chap0503/{id}")
    public String requestMethod3(@PathVariable("id") String userId, @MatrixVariable("pwd") String userPwd, Model model){
        model.addAttribute("userId", userId);
        model.addAttribute("userPwd", userPwd);
        return "viewPage05_01";
    }

    @GetMapping("/chap0504/{id1}/user/{id2}")
    public String requestMethod4(@MatrixVariable(pathVar = "id1") MultiValueMap<String, String> var1, @MatrixVariable(pathVar = "id2") MultiValueMap<String, String> var2,  Model model){
        model.addAttribute("title1", var1);
        model.addAttribute("title2", var2);
        return "viewPage";
    }
}
