package com.rengu.springboot.mapper;

import com.rengu.springboot.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by kang on 2020/7/21.
 */
@Mapper
public interface StudentMapper {
    public List<Student> getall();
    public void addone(Map<Object,Object> map);
}
