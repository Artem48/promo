package com.scnetcracker.service;

import com.scnetcracker.dao.UserImp;

public class UserServiceImp implements UserService { public UserServiceImp() {}
  UserImp user = new UserImp();
  
  public void createUser(String login, String password, String email, int vkId) {
    user.createUser(login, password, email, vkId);
  }
}
