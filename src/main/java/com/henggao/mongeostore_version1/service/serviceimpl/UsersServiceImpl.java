package com.henggao.mongeostore_version1.service.serviceimpl;

import com.henggao.mongeostore_version1.entity.Users;
import com.henggao.mongeostore_version1.repository.UsersRepository;
import com.henggao.mongeostore_version1.service.UsersService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersServiceImpl implements UsersService {

    @Resource
    private MongoTemplate mongoTemplate;
    @Resource
    private UsersRepository usersRepository;

    /**
     * 1、保存用户
     *
     * @param users
     */
    @Override
    public void saveUser(Users users) {
        usersRepository.save(users);
    }

    /**
     * 2、通过用户名删除
     *
     * @param name
     */
    @Override
    public void removeUserByUserName(String name) {
        Query query = new Query(new Criteria("username").is(name));
        mongoTemplate.remove(query, Users.class);
    }

    /**
     * 通过id来更新
     *
     * @param users
     */
    @Override
    public void updateUser(Users users) {
        Query query = new Query(new Criteria("id").is(users.getId()));
        Update update = new Update().set("username", users.getUsername());
        mongoTemplate.updateMulti(query, update, Users.class);
    }

    @Override
    public Users getByUserName(String Username) {
        return usersRepository.getByUsername(Username);
    }

    @Override
    public Users getByUserNameLike(String name) {
        return usersRepository.getByUsernameLike(name);
    }

}
