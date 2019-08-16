package com.henggao.mongeostore_version1.controller;

import com.henggao.mongeostore_version1.entity.Users;
import com.henggao.mongeostore_version1.repository.UsersRepository;
import com.henggao.mongeostore_version1.service.UsersService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersController {

    @Resource
    private UsersService usersService;
    private UsersRepository usersRepository;

    //增加几个用户
    @RequestMapping("/save")
    @ResponseBody
    public String saveUser() {
        for (int i = 0; i < 3; i++) {
            Users users = new Users();
            users.setId(i);
            users.setUsername("henggao" + i);
            users.setPassword("12345" + i);
            usersService.saveUser(users);
        }
        return "插入用户成功";
    }

    //删除henggao0
    @RequestMapping("/remove")
    @ResponseBody
    public String removeUserByUserName() {
        usersService.removeUserByUserName("henggao0");
        return "删除用户成功";
    }

    //把id为1号名字改一下
    @RequestMapping("/update")
    @ResponseBody
    public String updateUser() {
        Users user = new Users();
        user.setId(1);
        user.setUsername("geng");
        user.setPassword("123456");
        usersService.updateUser(user);
        return "更新用户信息成功";
    }

    //通过名字查询
    @RequestMapping("/getUserByUserName")
    @ResponseBody
    public Users getUserByUserName() {
        Users users = usersService.getByUserName("henggao2");
        return users;
    }

    //通过相似名字查询
    @RequestMapping("/getUserByUserNameLike")
    @ResponseBody
    public Users getUserByUserNameLike() {
        Users users = usersService.getByUserNameLike("henggao");
        return users;
    }

    @RequestMapping(value = "/usersList", method = RequestMethod.GET)
    public List<Users> usersList(){
        List<Users> usersList = usersRepository.findAll();
        return usersList;
    }

}
