package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class webcontroller {
    @RequestMapping("/")
    public String hello(){
        return "login";
    }
    @GetMapping("/resetpassword")
    public String resetpassword(){
        return "resetpassword";
    }
}
