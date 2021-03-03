package com.cheny.springboot.Controller;

import com.cheny.springboot.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/stu")
public class StudentController {

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
    }*/
    @RequestMapping(value = "/ins2")
    public ModelAndView ins2(Student student){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("data",student);
        modelAndView.setViewName("res");
        return modelAndView;
    }

    @RequestMapping(value = "/ins3")
    public ModelAndView ins3(){
        ModelAndView modelAndView=new ModelAndView();
        Student student=new Student();
        student.setAge(66);
        student.setName("fff");
        student.setId(6666);
        modelAndView.addObject("data2",student);
        modelAndView.setViewName("res");
        return modelAndView;
    }

    @RequestMapping(value = "/ajax")
    public String ajax(){
        return "ajax";
    }


}
