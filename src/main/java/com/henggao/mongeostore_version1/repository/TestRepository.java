package com.henggao.mongeostore_version1.repository;

import com.henggao.mongeostore_version1.entity.Test;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TestRepository extends MongoRepository<Test, ObjectId> {

    Test findByTitle(String title);

    @Override
    List<Test> findAll();
}
