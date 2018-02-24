package com.to4ka.managers;

import com.to4ka.entities.CategoriesEntity;
import com.to4ka.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by User on 2/24/2018.
 */
public class ProductsManager {

    public static Boolean createNewProduct(String name, Integer categoryId, String description){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try{

        }catch (Throwable ex){
            System.err.println("Transaction failed. Rollback.");
            transaction.rollback();
            return false;
        }

        return true;
    }
}
