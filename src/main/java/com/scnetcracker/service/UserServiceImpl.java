package com.scnetcracker.service;

import com.scnetcracker.dao.UserDao;
import com.scnetcracker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;
    public List<User> findAll() {
        return userDao.findall();
    }
}
