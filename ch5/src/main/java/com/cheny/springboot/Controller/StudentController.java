package com.cheny.springboot.Controller;

import com.cheny.springboot.domain.Student;
import com.cheny.springboot.service.impl.Myserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
/*@RequestMapping(value = "/stu")*/
public class StudentController {
    @Autowired
    private Myserviceimpl myserviceimpl;

    /*@RequestMapping(value = "/se",method = RequestMethod.GET)
    @ResponseBody
    public Student st(Integer id){
        Student student=myserviceimpl.querybyid(id);
        return student;
    }
    @GetMapping(value = "/ins")
    @ResponseBody
    public String ins(Student student){
        String conf="插入失败";
        int res=myserviceimpl.insert(student);
        if(res==1){
            conf="插入成功";
        }
        return conf;
    }

    @GetMapping(value = "/ins3/{name}/{age}")
    @ResponseBody
    public String ins3(@PathVariable String name, @PathVariable String age){
        Student student=new Student();
        student.setName(name);
        student.setAge(Integer.valueOf(age));
        String conf="插入失败";
        int res=myserviceimpl.insert(student);
        if(res==1){
            conf="插入成功";
        }
        return conf;
    }
    @RequestMapping(value = "/ins2")
    @ResponseBody
    public String ins2(Student student){
        String conf="插入失败";
        int res=myserviceimpl.insert2(student);
        if(res==1){
            conf="插入成功";
        }
        return conf;
    }*/
    @RequestMapping(value = "/login2")
    public String login(HttpServletRequest request,Integer id, Integer age){
        Student student=null;
        String res="";
        Object obj=myserviceimpl.sel(id,age);
        if (obj!=null){
            student= (Student) obj;
        }
        if(student!=null){
            request.getSession().setAttribute("user",student);
            res="success";
        }else {
            res="er";
        }
        System.out.println(res);
        return res;
    }
    @RequestMapping(value = {"","/login"})
    public String login2(){
        return "index";
    }


}
