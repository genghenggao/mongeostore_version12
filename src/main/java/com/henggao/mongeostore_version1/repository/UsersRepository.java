package com.henggao.mongeostore_version1.repository;


import com.henggao.mongeostore_version1.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UsersRepository extends MongoRepository<Users, Integer> {

    Users getByUsername(String username);

    Users getByUsernameLike(String username);

    @Override
    List<Users> findAll();
}
