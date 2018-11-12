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
    public List getPromosByIssueDate() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        Query query = session.createQuery("from PromocodesEntity ORDER BY issueDate");

        List<PromocodesEntity> list = (List<PromocodesEntity>) query.list();

        return list;
    }
//    public void createPromo(String Promo, String Description, String Shop, String Category, String ExpireDate){
//        Session session = HibernateSessionFactory.getSessionFactory().openSession();
//
//    session.beginTransaction();
//
//    PromocodesEntity promo = new PromocodesEntity();
//    promo.setPromo(Promo);
//    promo.setDescription(Description);
////    promo.setShopId();
////    promo.setParentId();
////    promo.setUserId();
////    promo.setIssueDate();
////    promo.setExpireDate();
//
//
//    session.save(promo);
//    session.getTransaction().commit();
//
//    session.getSessionFactory().close();
   // }

}
