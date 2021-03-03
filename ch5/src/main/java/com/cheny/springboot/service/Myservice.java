package com.cheny.springboot.service;

import com.cheny.springboot.domain.Student;

public interface Myservice {

    Student querybyid(Integer id);
    Integer insert(Student student);
    Student sel(Integer id,Integer age);
}
