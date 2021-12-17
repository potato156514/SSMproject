package project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.Beans.User;

import java.util.Map;

@RestController
public class restController {
    @PostMapping("/login")
    public Boolean handleLogin(@RequestBody User user){
        if(user != null) {
            System.out.println(user.toString());
            return true;
        }
        return false;
    }
}
