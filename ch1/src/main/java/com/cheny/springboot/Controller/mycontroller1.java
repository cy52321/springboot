package com.cheny.springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class mycontroller1 {
    @RequestMapping(value = "/say")
    @ResponseBody
    public String say(){
        return "Hello Worldwssd";
    }
}
