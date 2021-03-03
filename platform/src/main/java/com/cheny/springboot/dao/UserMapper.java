package com.cheny.springboot.dao;

import com.cheny.springboot.domain.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByNamePass(String name,String password);
    List<User> queryAll();
    int deleteByNamePass(String name,String password);
}