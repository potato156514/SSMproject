package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import project.Beans.User;
import project.DAO.UserDAO;

import javax.servlet.http.HttpSession;

@Controller
public class webcontroller {
    @Autowired
    UserDAO UserDAO;
    @RequestMapping("/")
    public String hello(){
        return "login";
    }
    @GetMapping("/resetpassword")
    public String resestpassword(){
        return "resetpassword";
    }
    @PostMapping("/login")
    public String login(User user, Model model, HttpSession session){
        if (user.getName().equals("")||user.getPassword().equals("")||user.getType()==0){
            model.addAttribute("erro","账号或密码不能为空");
            return "login";
        }

        String name=user.getName();
        String password=user.getPassword();
        User user1=UserDAO.selectUserBynameAndPassword(name,password, user.getType());
        if (user1==null) {
            model.addAttribute("erro","用户名或密码或登录方式错误");
            return "login";
        }
        else {
            if (user1.getType()==1) {
                session.setAttribute("user", user1);
                return "main";
            }
            else if (user1.getType()==2){
                session.setAttribute("user", user1);
                return "teacher";
            }else {
                session.setAttribute("user", user1);
                return "admin";
            }
        }
    }
    @PostMapping("/resetpassword")
    public String resetpassword(User user,String comfirmpassword,Model model,HttpSession session){
        if(user.getName().equals("")||user.getPhone().equals("")||user.getPassword().equals("")||comfirmpassword.equals("")){
            model.addAttribute("erro","文本框不能为空");
            return "resetpassword";
        }
        if (!user.getPassword().equals(comfirmpassword)){
            model.addAttribute("erro","两次密码输入不一致");
            return "resetpassword";
        }
        User user1=UserDAO.selectUserByNameAndPhone(user.getName(),user.getPhone());
        if (!UserDAO.updateUserPassword(comfirmpassword,user1.getId())){
            model.addAttribute("erro","密码更新失败");
            return "resetpassword";
        }else {
            model.addAttribute("success","重置密码成功");
            return "login";
        }

    }
}
