package com.scnetcracker.dao;

import com.scnetcracker.entity.UsersEntity;
import com.scnetcracker.utils.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserImp implements User
{
  public UserImp() {}
  
  public void createUser(String login, String password, String email)
  {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    
    session.beginTransaction();
    
    UsersEntity user = new UsersEntity();
    user.setLogin(login);
    user.setPassword(password);
    user.setEmail(email);
    user.setGroupId(1);
    
    session.save(user);
    session.getTransaction().commit();

  }

  @Override
  public List getUser(String email) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    session.beginTransaction();
    Query query = session.createQuery("from UsersEntity where email = :Email");
    query.setParameter("Email", email);

    List<UsersEntity> list = (List<UsersEntity>)query.list();

    return list;
  }


}
