package com.rengu.springboot.services.imp;

import com.rengu.springboot.entity.Student;
import com.rengu.springboot.mapper.StudentMapper;
import com.rengu.springboot.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kang on 2020/7/21.
 */
@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    //注入springboot提供的redis的模板
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Override
    public List<Student> getallstu() {
        //redis的序列化器
        RedisSerializer rs=new StringRedisSerializer();
        redisTemplate.setKeySerializer(rs);
        //查询缓存
        List<Student> stu=(List<Student>)redisTemplate.opsForValue().get("allstudent");
        if(stu==null) {
            synchronized (this) {
                stu = (List<Student>) redisTemplate.opsForValue().get("allstudent");
                if (stu == null) {
                    stu = studentMapper.getall();
                    //放入缓存
                    redisTemplate.opsForValue().set("allstudent", stu);
                    System.out.println("放入缓存成功");
                } else {
                    System.out.println("使用缓存成功");
                }

            }
        }else{
            System.out.println("使用缓存成功");
        }
            return stu;
    }

    @Override
    public void addstu() {
        Map<Object,Object> map=new HashMap<>();
        map.put("uId",Integer.valueOf("4"));
        map.put("uName","老王");
        map.put("uage","21");
        map.put("addr","河南省");
        map.put("city","漯河市");
        studentMapper.addone(map);
    }
}
