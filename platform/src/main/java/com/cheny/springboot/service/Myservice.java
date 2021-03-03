package com.cheny.springboot.service;

import com.cheny.springboot.domain.User;

import java.util.List;

public interface Myservice {

    User querybynamepass(String name,String password);
    Integer insert(User user);
    List<User> queryAll();
    int delete(String name,String password);
}
