package com.cheny.springboot.service.impl;

import com.cheny.springboot.dao.UserMapper;
import com.cheny.springboot.domain.User;
import com.cheny.springboot.service.Myservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class Myserviceimpl implements Myservice {
    @Autowired
    private UserMapper mapper;
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    @Transactional
    public User querybynamepass(String name, String password) {
        User user=null;/*
        user= (User) redisTemplate.opsForValue().get(name);*/
        if(user==null){
            user=mapper.selectByNamePass(name, password);/*
            redisTemplate.opsForValue().set(name,user,60, TimeUnit.SECONDS);*/
        }
        return user;
    }

    @Override
    @Transactional
    public Integer insert(User user) {
        int a=mapper.insert(user);
        return a;
    }

    @Override
    @Transactional
    public List<User> queryAll() {
        List<User> list=mapper.queryAll();
        return list;
    }

    @Override
    @Transactional
    public int delete(String name, String password) {
        int a=mapper.deleteByNamePass(name,password);
        return a;
    }
}
