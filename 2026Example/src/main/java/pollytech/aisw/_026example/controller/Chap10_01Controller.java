package pollytech.aisw._026example.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/exam10_01")
public class Chap10_01Controller {

    @GetMapping("/exam01")
    public String requestMethod(Model model){
        return "viewPage10_01";
    }

    @GetMapping("/admin/main")
    public String requestMethod2(Model model){
        model.addAttribute("viewName", "adminPage.html");
        return "adminPage";
    }

    @GetMapping("/manager/main")
    public String requestMethod3(Model model){
        model.addAttribute("viewName", "managerPage.html");
        return "managerPage";
    }

    @GetMapping("/member/main")
    public String requestMethod4(Model model){
        model.addAttribute("viewName", "memberPage.html");
        return "memberPage";
    }

    @GetMapping("/home/main")
    public String requestMethod5(Model model){
        return "homePage";
    }

    @GetMapping("/exam02")
    public String requestMethod6(Model model){
        return "redirect:/exam10_01/member/user";
    }

    @GetMapping("/member/user")
    public String requestMethod7(Authentication authentication, Model model){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String userName = userDetails.getUsername();
        String password = userDetails.getPassword();
        model.addAttribute("userName", userName);
        model.addAttribute("password", password);
        model.addAttribute("uri", "/member/user");
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        for (GrantedAuthority item : authorities){
            model.addAttribute("role", item + " ");
        }

        return "viewPage10_02";
    }

    @GetMapping("/exam03")
    public String requestMethod8(Model model){
        return "viewPage10_03";
    }

    @GetMapping("/manager/tag")
    public String requestMethod9(Model model){
        return "viewPage10_03";
    }

    @GetMapping("/exam04")
    public String requesMethod10(Model model){
        return "viewPage10_04";
    }

    @GetMapping("/admin/tag")
    public String requesMethod11(Model model){
        return "viewPage10_04";
    }

    @GetMapping("/exam05")
    public String requesMethod12(Model model){
        return "viewPage10_05";
    }

    @GetMapping("/admin")
    public String requesMethod13(Authentication user, Model model){
        model.addAttribute("username", user.getName());
        return "viewPage10_05_result";
    }

    @GetMapping("/logout")
    public String requesMethod14(Model model){
        return "viewPage10_05";
    }
}
