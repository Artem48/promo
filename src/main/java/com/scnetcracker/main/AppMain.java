package com.scnetcracker.main;

import com.scnetcracker.utils.HibernateSessionFactory;

import org.hibernate.Session;

/**
first try
 */
public class AppMain {

    public static void main(String[] args) {
        System.out.println("Hibernate tutorial");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        /**
         first try to start
         */
        session.getTransaction().commit();

        session.close();


    }
}
