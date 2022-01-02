package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import project.Beans.User;

@Controller
public class testController {
    @GetMapping("/test")
    public String test(){
        return "admins";
    }
//    @PostMapping("/test")
//    @ResponseBody
//    public boolean test(@RequestBody User user){
//        if(user == null || user.getName().equals("123")) return false;
//        System.out.println(user.toString());
//        return true;
////        return "admins";
//    }

}
