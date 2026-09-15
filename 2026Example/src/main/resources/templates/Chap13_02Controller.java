package pollytech.aisw._026example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequestMapping("/exam13_02")
public class Chap13_02Controller {
    @GetMapping
    public String showForm(){
        return "viewPage13_02_form";
    }

//    @RequestBody는 폼의 input 태그의 name과  사용자가 입력된 값을 사용해서 키와 값으로 구성된 json형식의 Rest 문자열로 만듬
    @PostMapping
    @ResponseBody
    public String submit(@RequestBody HashMap<String, String> map){
        System.out.println(map);
        return "데이터전송 성공";
    }
}
