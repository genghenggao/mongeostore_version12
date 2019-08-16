package com.henggao.mongeostore_version1.controller;

import com.henggao.mongeostore_version1.entity.Student;
import com.henggao.mongeostore_version1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("students",studentService.getStudents());
        return "student";
    }

    @RequestMapping(value = "/queryStudents")
    public List<Student> queryStudent() {
        return studentService.getStudents();
    }

    @RequestMapping(value = "getStudent/{id}")
    public Student getStudent(@PathVariable String id) {
        return studentService.getStudent(id);
    }

    @RequestMapping("/add")
    public void insert(Student student) {
        studentService.add(student);
    }

    @RequestMapping("/update")
    public void update(Student student) {
        studentService.update(student);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        studentService.delete(id);
    }
}
