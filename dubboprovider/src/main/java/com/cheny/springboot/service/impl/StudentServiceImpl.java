package com.cheny.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cheny.springboot.dao.StudentMapper;
import com.cheny.springboot.domain.Student;
import com.cheny.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Service(interfaceClass=StudentService.class,version="1.0.0",timeout=15000)
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Override
    public Student querybyid(Integer id) {
        Student student=null;
        student=(Student)redisTemplate.opsForValue().get("id");
        if (student == null) {
            student=studentMapper.selectByPrimaryKey(id);
            redisTemplate.opsForValue().set("id",student,60, TimeUnit.SECONDS);
        }

        return student;
    }

    @Override
    public Integer querycount() {
        return studentMapper.count();
    }
}
