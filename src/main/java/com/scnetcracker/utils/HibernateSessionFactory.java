package com.scnetcracker.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionFactory
{
  private static SessionFactory sessionFactory =buildSessionFactory() ;
  
  public HibernateSessionFactory() {}
  
  private static SessionFactory buildSessionFactory()
  {
    StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    try {
      sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

    }
    catch (Exception e)
    {
      StandardServiceRegistryBuilder.destroy(registry);
      
      throw new ExceptionInInitializerError("Initial SessionFactory failed" + e);
    }
    return sessionFactory;
  }
  
  public static SessionFactory getSessionFactory()
  {
    return sessionFactory;
  }
  
  public static void shutdown()
  {
    getSessionFactory().close();
  }
}
