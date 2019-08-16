package com.henggao.mongeostore_version1.repository.impl;

import com.henggao.mongeostore_version1.entity.Student;
import com.henggao.mongeostore_version1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Student> getStudents() {
        return mongoTemplate.findAll(Student.class);
    }

    @Override
    public Student getStudent(String id) {
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)), Student.class);
    }

    @Override
    public void insert(Student student) {
        mongoTemplate.insert(student);
    }

    @Override
    public void update(Student student) {
        Criteria criteria = Criteria.where("id").is(student.get_id());
        Query query = new Query(criteria);
        Update update = Update.update("name", student.getName()).set("set", student.getAge());
        mongoTemplate.updateMulti(query, update, Student.class);
    }

    @Override
    public void delete(String id) {
        Criteria criteria = Criteria.where("id").is(id);
        Query query = new Query(criteria);
        mongoTemplate.remove(query, Student.class);
    }
}
