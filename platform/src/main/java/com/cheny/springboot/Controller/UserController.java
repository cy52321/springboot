package com.cheny.springboot.Controller;

import com.cheny.springboot.domain.User;
import com.cheny.springboot.service.impl.Myserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private Myserviceimpl myserviceimpl;

    @RequestMapping(value = "/login2")
    public String login(HttpServletRequest request,String name, String password){
        User user=null;
        String res="";
        Object obj=myserviceimpl.querybynamepass(name,password);
        if (obj!=null){
            user= (User) obj;
            request.getSession().setAttribute("user",user);
            res="origin/index2";
        } else {
            res="login_error";
        }
        return res;
    }
    @RequestMapping(value = "/useradd")
    public String useradd(User user){
        Integer integer=myserviceimpl.insert(user);
        String res="";
        if (integer==1){
            res="user/addsuccess";
        }else {
            res="user/adderror";
        }
        return res;
    }

    @RequestMapping(value = "/userdelete")
    public String userdelete(String name,String password){
        int a=myserviceimpl.delete(name,password);
        String res="";
        if (a==1){
            res="user/deletesuccess";
        }else {
            res="user/deleteerror";
        }
        return res;
    }
    @RequestMapping(value = "/queryall")
    @ResponseBody
    public List<User> queryall(){
        List<User> list=myserviceimpl.queryAll();
        return list;
    }

    @RequestMapping(value = {"","/login"})
    public String login2(){
        return "login";
    }


}
