package com.scnetcracker.dao;

import com.scnetcracker.entity.PromocodesEntity;
import com.scnetcracker.utils.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

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
}
