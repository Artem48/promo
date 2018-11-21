package com.scnetcracker.dao;

import com.scnetcracker.entity.CategoriesEntity;
import com.scnetcracker.utils.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class CategoryImp implements Category {
    @Override
    public List getCategory(int categoryId) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        Query query = session.createQuery("from CategoriesEntity WHERE id = :CategoryId");
        query.setParameter("CategoryId", categoryId);

        List<CategoriesEntity> list = (List<CategoriesEntity>) query.list();

        return list;
    }

    public List getCategory(String name) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        Query query = session.createQuery("from CategoriesEntity WHERE name = :name");
        query.setParameter("name", name);

        List<CategoriesEntity> list = (List<CategoriesEntity>) query.list();

        return list;
    }

    public List getCategories() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        Query query = session.createQuery("from CategoriesEntity WHERE parentID IS NULL");

        List<CategoriesEntity> list = (List<CategoriesEntity>) query.list();

        return list;
    }

    public List getChildrenCategory(int Id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        Query query = session.createQuery("from CategoriesEntity WHERE parentID = :Id");
        query.setParameter("Id", Id);

        List<CategoriesEntity> list = (List<CategoriesEntity>) query.list();

        return list;
    }
}
