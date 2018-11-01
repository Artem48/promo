package com.scnetcracker.dao;

import com.scnetcracker.entity.UsersEntity;

@org.springframework.stereotype.Repository
public class UserImp implements User
{
  public UserImp() {}
  
  public void createUser(String login, String password, String email, int vkId)
  {
    org.hibernate.Session session = com.scnetcracker.utils.HibernateSessionFactory.getSessionFactory().openSession();
    
    session.beginTransaction();
    
    UsersEntity user = new UsersEntity();
    user.setLogin(login);
    user.setPassword(password);
    user.setEmail(email);
    user.setVkId(Integer.valueOf(vkId));
    user.setGroupID(1);
    
    session.save(user);
    session.getTransaction().commit();
    
    session.getSessionFactory().close();
  }
}
