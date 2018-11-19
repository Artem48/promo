package com.scnetcracker.dao;

import com.scnetcracker.entity.CategoriesEntity;
import com.scnetcracker.entity.PromocodesEntity;
import com.scnetcracker.entity.ShopsEntity;
import com.scnetcracker.entity.UsersEntity;
import com.scnetcracker.utils.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import com.scnetcracker.dao.Shops;

public class PromoImp implements Promo {
    @Override
    public List getUserPromo(int userId) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        Query query = session.createQuery("from PromocodesEntity WHERE userId = :userId");
        query.setParameter("userId", userId);

        List<PromocodesEntity> list = (List<PromocodesEntity>) query.list();

        return list;
    }

    public List getPromosByIssueDate() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        Query query = session.createQuery("from PromocodesEntity ORDER BY issueDate");

        List<PromocodesEntity> list = (List<PromocodesEntity>) query.list();

        return list;
    }

    public void createPromo(String Promo, String Description, String Shop, String Category, String ExpireDate, String User) {

        List<UsersEntity> user;
        UserImp userimp = new UserImp();
        user = userimp.getUser(User);

        PromocodesEntity promo = new PromocodesEntity();
        promo.setPromo(Promo);
        promo.setDescription(Description);
        promo.setShopId(Integer.parseInt(Shop));
        promo.setCategoryId(Integer.parseInt(Category));
        promo.setUserId(user.get(0).getId());
        promo.setIssueDate(Date.valueOf(LocalDate.now()));
        promo.setExpireDate(Date.valueOf(ExpireDate));

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(promo);
        session.getTransaction().commit();

    }

}
