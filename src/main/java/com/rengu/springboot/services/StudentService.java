package com.rengu.springboot.services;

import com.rengu.springboot.entity.Student;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/**
 * Created by kang on 2020/7/21.
 */
public interface StudentService {
    public List<Student>  getallstu();
    public void addstu();

}
