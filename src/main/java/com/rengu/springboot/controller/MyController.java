package com.rengu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * Created by kang on 2020/7/20.
 */
@Controller
public class MyController {
    @RequestMapping("/boot/wel")
    public @ResponseBody String SayHello(Model model){
        System.out.println("你好springboot");
        model.addAttribute("msg","love my sjjj");
        return "Welcome";
    }
}
