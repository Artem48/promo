package com.scnetcracker.service;

import com.scnetcracker.dao.UserImp;

import java.util.List;

public class UserServiceImp implements UserService {

    UserImp user = new UserImp();

    @Override
    public void createUser(String login, String password, String email) {
        user.createUser(login, password, email);
    }

    @Override
    public List getUser(String Email) {
        return user.getUser(Email);
    }

}
