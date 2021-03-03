package com.cheny.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cheny.springboot.domain.Student;
import com.cheny.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/student")
public class StudentController {/*
    @Reference(interfaceClass = StudentService.class,version = "1.0.0",check = false)*/
    @Reference(interfaceName = "com.cheny.springboot.service.StudentService",version = "1.0.0",check = false)
    private StudentService studentService;

    /*@RequestMapping(value = "/stu")
    @ResponseBody
    public Student querystu(Integer id){
        Student student=studentService.querybyid(id);
        return student;
    }*/
    @RequestMapping(value = "/stu")
    public ModelAndView querystu(Integer id){
        Student student=studentService.querybyid(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("student",student);
        modelAndView.setViewName("res");

        return modelAndView;
    }

    @RequestMapping(value = "/cou")
    @ResponseBody
    public Integer querycou(){
        Integer count=studentService.querycount();
        return count;
    }

}
