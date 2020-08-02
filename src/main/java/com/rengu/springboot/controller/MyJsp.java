package com.rengu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by kang on 2020/7/20.
 */
@Controller
public class MyJsp {
    @RequestMapping("/jsp")
    public  String SayHello(Model model){
        System.out.println("成功了");
        model.addAttribute("msg","ccccccccc");
        return "index";
    }
}
