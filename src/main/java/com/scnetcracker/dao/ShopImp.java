package com.scnetcracker.dao;

import com.scnetcracker.entity.ShopsEntity;
import com.scnetcracker.utils.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class ShopImp implements Shops {
    @Override
    public List getShop(int shopId) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        Query query = session.createQuery("from ShopsEntity WHERE id = :shopId");
        query.setParameter("shopId", shopId);

        List<ShopsEntity> list = (List<ShopsEntity>) query.list();

        return list;
    }

    public List getShops() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        Query query = session.createQuery("from ShopsEntity ORDER BY name");

        List<ShopsEntity> list = (List<ShopsEntity>) query.list();

        return list;
    }
}
