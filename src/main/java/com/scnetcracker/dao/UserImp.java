package com.scnetcracker.dao;

import com.scnetcracker.entity.PromocodesEntity;
import com.scnetcracker.entity.ShopsEntity;
import com.scnetcracker.entity.UsersEntity;
import com.scnetcracker.utils.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

@org.springframework.stereotype.Repository
public class UserImp implements User
{
  public UserImp() {}
  
  public void createUser(String login, String password, String email, int vkId)
  {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    
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

  @Override
  public List getUser(String email) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();

    session.beginTransaction();

    Query query = session.createQuery("from UsersEntity where email = :Email");
    query.setParameter("Email", email);

    List<UsersEntity> list = (List<UsersEntity>)query.list();

    return list;
  }

  @Override
  public List getUserPromo(int userId) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();

    session.beginTransaction();

    Query query = session.createQuery("from PromocodesEntity WHERE userId = :userId");
    query.setParameter("userId", userId);

    List<PromocodesEntity> list = (List<PromocodesEntity>)query.list();

    return list;
  }

  @Override
  public List getShop(int shopId) {
    Session session = HibernateSessionFactory.getSessionFactory().openSession();

    session.beginTransaction();

    Query query = session.createQuery("from ShopsEntity WHERE id = :shopId");
    query.setParameter("shopId", shopId);

    List<ShopsEntity> list = (List<ShopsEntity>)query.list();

    return list;
  }
}
