package com.to4ka.managers;

import com.to4ka.entities.CategoriesEntity;
import com.to4ka.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by User on 2/18/2018.
 */
public class CategoriesManager {

    public static CategoriesEntity createNewCategory(String name, Integer parentId){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        CategoriesEntity category = new CategoriesEntity();
        category.setName(name);
        if(parentId != null)
            category.setParentId(parentId);

        session.save(category);

        session.getTransaction().commit();
        return category;
    }

    public static Set<CategoriesEntity> getAllCategories() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<CategoriesEntity> result = (List<CategoriesEntity>)session.createQuery("from CategoriesEntity").list();
        session.getTransaction().commit();

        return new HashSet<CategoriesEntity>(result);
    }

    public static CategoriesEntity getCategoryById(Integer id) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        CategoriesEntity result = (CategoriesEntity)session.createQuery(
                String.format("from CategoriesEntity where id like '%s'", id)).getSingleResult();
        session.getTransaction().commit();

        return result;
    }

    public static Boolean removeCategoryById(Integer id) throws Throwable {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try{
            String hql = "delete from CategoriesEntity where id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            System.out.println(query.executeUpdate());

            transaction.commit();
        }
        catch(Throwable ex){
            System.err.println("Transaction failed. Rollback.");
            transaction.rollback();
            return false;
        }

        return true;
    }
}
