package project.controller;

import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import project.Beans.Shiyaninf;
import project.Beans.User;
import project.DAO.UserDAO;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
                session.setAttribute("user", user1.getId());
                return "student";
            }
            else if (user1.getType()==2){
                session.setAttribute("user", user1.getId());
                return "teacher";
            }else {
                ArrayList<User> stu = new ArrayList<>();
                ArrayList<User> tea=new ArrayList<>();
                ArrayList<Shiyaninf> shiyaninfs=new ArrayList<>();
                session.setAttribute("user", user1.getId());
                session.setAttribute("student",stu);
                session.setAttribute("teacher",tea);
                session.setAttribute("shiyaninfs",shiyaninfs);
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
    @PostMapping("/addstu")
    public String addstu(User user,HttpSession session,Model model) {
        if (user.getName().equals("") || user.getPassword().equals("") || user.getPhone().equals("") || user.getPeopleID().equals("")) {
            model.addAttribute("erro", "请完善信息");
            return "admin";
        }
        user.setType(1);
        if (!UserDAO.insertStudent(user)) {
            model.addAttribute("erro", "插入学生信息失败");
            return "admin";
        } else {
            model.addAttribute("success","插入成功");
            return "admin";
        }
    }
}
