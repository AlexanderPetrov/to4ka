package com.to4ka.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Created by User on 2/9/2018.
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try{
            return new Configuration().configure().buildSessionFactory();
        }
        catch(Throwable ex){
            System.err.println("Initial SessionFactory failed." + ex);
            throw  new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
