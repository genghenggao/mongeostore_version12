package com.henggao.mongeostore_version1.repository;

import com.henggao.mongeostore_version1.entity.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getStudents();

    Student getStudent(String id);

    void insert(Student student);

    void update(Student student);

    void delete(String id);
}
