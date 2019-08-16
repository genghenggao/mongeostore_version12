package com.henggao.mongeostore_version1.service.serviceimpl;

import com.henggao.mongeostore_version1.entity.Student;
import com.henggao.mongeostore_version1.repository.StudentRepository;
import com.henggao.mongeostore_version1.repository.UsersRepository;
import com.henggao.mongeostore_version1.repository.impl.StudentRepositoryImpl;
import com.henggao.mongeostore_version1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getStudents() {
        return studentRepository.getStudents();
    }

    @Override
    public Student getStudent(String id) {
        return studentRepository.getStudent(id);
    }

    @Override
    public void update(Student student) {
        studentRepository.update(student);
    }

    @Override
    public void add(Student student) {
        studentRepository.insert(student);
    }

    @Override
    public void delete(String id) {
        studentRepository.delete(id);
    }
}
