package com.henggao.mongeostore_version1.service;

import com.henggao.mongeostore_version1.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();

    Student getStudent(String id);

    void update(Student student);

    void add(Student student);

    void delete(String id);
}

