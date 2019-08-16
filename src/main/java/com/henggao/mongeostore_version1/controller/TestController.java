package com.henggao.mongeostore_version1.controller;

import com.henggao.mongeostore_version1.entity.Test;
import com.henggao.mongeostore_version1.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @RequestMapping(value = "/test_mongodb", method = RequestMethod.GET)
    public Test test_mongodb() {
        Test test = testRepository.findByTitle("MongoDB");
        return test;
    }

    @RequestMapping(value = "/testList", method = RequestMethod.GET)
    public List<Test> testList(){
        List<Test> testList = testRepository.findAll();
        return testList;
    }
}
