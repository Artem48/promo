package com.scnetcracker.service;

import com.scnetcracker.dao.UserImp;

import java.util.List;

public class UserServiceImp implements UserService {
    public UserServiceImp() {
    }

    UserImp user = new UserImp();

    public void createUser(String login, String password, String email, int vkId) {
        user.createUser(login, password, email, vkId);
    }

    @Override
    public List getUser(String Email) {
        return user.getUser(Email);
    }

    @Override
    public List getUserPromo(int userId) {
        return user.getUserPromo(userId);
    }

    @Override
    public List getShop(int id) {
        return user.getShop(id);
    }
}
