package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.Beans.MyShiYan;
import project.Beans.Shiyaninf;
import project.Beans.User;
import project.DAO.ShiyanDAO;
import project.DAO.UserDAO;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
//@Controller
public class restController {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ShiyanDAO shiyanDAO;
//    @PostMapping("/login")
//    public Boolean handleLogin(@RequestBody User user){
//        if(user != null) {
//            System.out.println(user.toString());
//            return true;
//        }
//        return false;
//    }
    @PostMapping("/test")
    public Map<String,Object> test(@RequestBody User user){
        Map<String,Object> map = new HashMap<String,Object>();
        if(user == null
                || user.getName() == null
                || user.getPassword() == null
                || user.getPhone() == null
                || user.getPeopleID() == null) {
            map.put("res",false);
            return map;
        };
        System.out.println(user.toString());
        map.put("res",true);
        ArrayList<Integer> users = new ArrayList<>();
        users.add(1);
        users.add(3);
        map.put("data",users);
        return map;
//        return userDAO.insertStudent(user);
//        return true;
//        return "admins";
    }
    @PostMapping("AllShiyan")
    public ArrayList<Shiyaninf> handleAllShiyan(){
        ArrayList<Shiyaninf> shiyaninfs = shiyanDAO.selectAllShiyan();
        return shiyaninfs;
    }
    @PostMapping("chooseShiyan")
    public boolean handleChooseShiyan(@RequestBody Shiyaninf shiyaninf , HttpSession session){
        System.out.println("shiyanId:" + shiyaninf.getId());
        System.out.println("name:"+session.getAttribute("user"));
        return shiyanDAO.shiyanChoose((Integer) session.getAttribute("user"),shiyaninf.getId());
//        return true;
    }
    @PostMapping("getMyShiYan")
    public ArrayList<MyShiYan> selectMyShiYan(HttpSession session){
        return shiyanDAO.selectMyShiYan((Integer) session.getAttribute("user"));

    }

}
