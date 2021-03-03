package com.cheny.springboot.Controller;

import com.cheny.springboot.domain.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Mycontroller {
    @Autowired
    private School school;
    @RequestMapping(value = "/say")
    public ModelAndView doSome(Integer age){
        ModelAndView mv=new ModelAndView();
        mv.addObject("na",age);
        mv.addObject("xuexiao",school);
        mv.setViewName("say");
        return mv;
    }
}
