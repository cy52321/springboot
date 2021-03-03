package com.cheny.springboot.service.impl;

import com.cheny.springboot.dao.StudentMapper;
import com.cheny.springboot.domain.Student;
import com.cheny.springboot.service.Myservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
public class Myserviceimpl implements Myservice {
    @Autowired
    private StudentMapper mapper;
    private RedisTemplate<Integer,Student> redisTemplate;
    @Override
    @Transactional
    public Student querybyid(Integer id) {
        Student student=null;
        student=redisTemplate.opsForValue().get(id);
        if(student==null){
            student=mapper.selectByPrimaryKey(id);
            redisTemplate.opsForValue().set(id,student,60, TimeUnit.SECONDS);
        }
        return student;
    }

    @Override
    @Transactional
    public Integer insert(Student student) {
        int a=mapper.insert(student);
        return a;
    }
    /*@Override
    @Transactional
    public Integer insert2(Student student) {
        int a=mapper.insert(student);
        int b=10/0;
        return a;
    }*/

    @Override
    public Student sel(Integer id, Integer age) {
        return mapper.selectbyidage(id,age);
    }
}
