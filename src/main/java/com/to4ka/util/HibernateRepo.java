package com.to4ka.util;


import com.to4ka.entities.CategoriesEntity;
import com.to4ka.exceptions.To4kaException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by User on 2/9/2018.
 */
public class HibernateRepo<T> {

    private Logger log = LoggerFactory.getLogger(HibernateRepo.class);

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try{
            return new Configuration().configure().buildSessionFactory();
        }
        catch(Throwable ex){
            System.err.println("Initial SessionFactory failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void save(T object) throws Exception {
        log.debug("Open session");
        Session session = getSessionFactory().openSession();
        log.debug("Begin transaction");
        session.beginTransaction();

        try {
            log.debug("Save object [%s] to database", object.toString());
            session.save(object);
            log.debug("Commit transaction");
            session.getTransaction().commit();
        }catch (Exception ex){
            log.error("Transaction failed. Roll back");
            session.getTransaction().rollback();
            session.close();
            throw new Exception(ex.getMessage(), ex);
        }finally {
            session.close();
        }
    }

    public void save(T[] objects) throws Exception {
        log.debug("Open session");
        Session session = getSessionFactory().openSession();
        log.debug("Begin transaction");
        session.beginTransaction();

        try {
            log.debug("Save objects:");
            for (Object object : objects) {
                log.debug(String.format("Save object:\n%s", object.toString()));
                session.save(object);
            }

            log.debug("Commit transaction");
            session.getTransaction().commit();
        }catch (Exception ex){
            log.error("Transaction failed. Roll back", ex);
            session.getTransaction().rollback();
            log.debug("Close session");
            session.close();
            throw  new Exception(ex.getMessage(), ex);
        }finally {
            log.debug("Close session");
            session.close();
        }
    }

    public void delete(T object) throws Exception {
        log.debug("Open session");
        Session session = getSessionFactory().openSession();
        log.debug("Begin transaction");
        session.beginTransaction();

        try {
            log.debug(String.format("Delete object from database:\n%s", object.toString()));
            session.delete(object);

            log.debug("Commit transaction");
            session.getTransaction().commit();
        }catch (Exception ex){
            log.error("Transaction failed. Roll back");
            session.getTransaction().rollback();
            log.debug("Close session");
            session.close();
            throw new Exception(ex.getMessage(), ex);
        }finally {
            log.debug("Close session");
            session.close();
        }
    }

    public void delete(T[] objects) throws Exception {
        log.debug("Open session");
        Session session = getSessionFactory().openSession();
        log.debug("Begin transaction");
        session.beginTransaction();

        try {
            log.debug("Delete objects");
            for (Object object : objects) {
                log.debug(String.format("Delete object:\n%s", object.toString()));
                session.delete(object);
            }

            log.debug("Commit transaction");
            session.getTransaction().commit();
        }catch (Exception ex){
            log.error("Transaction failed. Roll back.");
            session.getTransaction().rollback();
            log.debug("Close session");
            session.close();
            throw new Exception(ex.getMessage(), ex);
        }finally {
            log.debug("Close session");
            session.close();
        }
    }

    public T selectOne(String queryStr) throws Exception {
        log.debug("Open session");
        Session session = getSessionFactory().openSession();
        T result = null;
        try {
            log.debug(String.format("Create query [%s]", queryStr));
            Query query = session.createQuery(queryStr);
            log.debug(String.format("Execute query [%s]", queryStr));
            result = (T)query.getSingleResult();
        } catch (Exception ex) {
            log.error(String.format("Query failed. Message: %s", ex.getMessage()));
            log.debug("Close session");
            session.close();
            throw new Exception(ex.getMessage(), ex);
        }
        finally {
            log.debug("Close session");
            session.close();
        }

        return result;
    }

    public Collection<T> select(String queryStr) throws Exception {
        log.debug("Open session");
        Session session = getSessionFactory().openSession();
        Collection<T> result = null;
        try {
            log.debug(String.format("Create query [%s]", queryStr));
            Query query = session.createQuery(queryStr);
            log.debug("Execute query");
            result = (Collection<T>)query.list();
        } catch (Exception e) {
            log.error(String.format("Query failed. Message: %s", e.getMessage()));
            log.debug("Close session");
            session.close();
            throw new Exception(e.getMessage(), e);
        }
        finally {
            log.debug("Close session");
            session.close();
        }

        return result;
    }

    public void executeQuery(String queryStr) throws Exception {
        log.debug("Open session");
        Session session = getSessionFactory().openSession();
        try {
            log.debug(String.format("Create query [%s]", queryStr));
            Query query = session.createQuery(queryStr);
            log.debug("Execute query");
            query.executeUpdate();
        } catch (Exception ex) {
            log.error(String.format("Query failed. Message: %s", ex.getMessage()));
            log.debug("Close session");
            session.close();
            throw new Exception(ex.getMessage(), ex);
        }
        finally {
            log.debug("Close session");
            session.close();
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
