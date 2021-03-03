package com.cheny.springboot.Controller;

import com.cheny.springboot.domain.home;
import com.cheny.springboot.domain.school;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class Mycontroller1 {

    /*@Value("${school.name}")
    private String name;
    @Value("${school.address}")
    private String address;*/
    @Autowired
    private school school;
    @Resource
    private home home;
    @RequestMapping(value = "/say")
    @ResponseBody
    public String say(){
        return "name:"+school.getName()+" address:"+home.getAddress();
    }
}
