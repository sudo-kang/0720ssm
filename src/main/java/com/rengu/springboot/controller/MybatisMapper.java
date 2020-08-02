package com.rengu.springboot.controller;

import com.rengu.springboot.entity.Student;
import com.rengu.springboot.mapper.StudentMapper;
import com.rengu.springboot.services.imp.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by kang on 2020/7/21.
 */
@Controller
public class MybatisMapper {
    @Autowired

   StudentServiceImp studentServiceImp;
    @RequestMapping("/mybatis/get")
    public@ResponseBody Object getstu(){
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100000;i++){
                    studentServiceImp.getallstu();
                }

            }
        };
    //利用线程并发测试缓存穿透
        ExecutorService executorService= Executors.newFixedThreadPool(1000);
        executorService.submit(runnable);
        return studentServiceImp.getallstu();
    }
    @RequestMapping("/mybatis/add")
    public@ResponseBody Object addstu(){
       studentServiceImp.addstu();
        return "成功添加一条记录";
    }
}
