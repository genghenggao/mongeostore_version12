package com.henggao.mongeostore_version1.service;

import com.henggao.mongeostore_version1.entity.Users;

public interface UsersService {
    public void saveUser(Users users);
    public void removeUserByUserName(String name);
    public void updateUser(Users users);
    public Users getByUserName(String Username);
    public Users getByUserNameLike(String name);
}
