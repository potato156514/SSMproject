package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.Beans.User;

@RestController
//@Controller
public class restController {
//    @PostMapping("/login")
//    public Boolean handleLogin(@RequestBody User user){
//        if(user != null) {
//            System.out.println(user.toString());
//            return true;
//        }
//        return false;
//    }
    @PostMapping("/test")
    public boolean test(@RequestBody User user){
        if(user == null) return false;
        System.out.println(user.toString());
        return true;
//        return "admins";
    }

}
