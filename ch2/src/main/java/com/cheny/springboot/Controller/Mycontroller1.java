package com.cheny.springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Mycontroller1 {
    @RequestMapping(value = "/say")
    @ResponseBody
    public String say(String name,Integer id){
        return "Hello,World"+name+id;
    }
}
