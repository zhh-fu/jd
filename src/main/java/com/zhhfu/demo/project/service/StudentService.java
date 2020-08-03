package com.zhhfu.demo.project.service;


import com.zhhfu.demo.project.entity.StudentEntity;

import java.util.List;

public interface StudentService {
    List<StudentEntity> findAll();

    StudentEntity findStudentById(int id);

    StudentEntity findStudentByName(String name);

    int countStudentNum();

    int addStudent(StudentEntity student);
}
