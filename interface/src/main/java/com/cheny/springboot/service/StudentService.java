package com.cheny.springboot.service;

import com.cheny.springboot.domain.Student;

public interface StudentService {

    Student querybyid(Integer id);
    Integer querycount();
}
