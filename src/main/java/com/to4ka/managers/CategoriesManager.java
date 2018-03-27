package com.to4ka.managers;

import com.to4ka.entities.CategoriesEntity;
import com.to4ka.exceptions.To4kaException;
import com.to4ka.util.HibernateRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;

/**
 * Created by User on 2/18/2018.
 */
public class CategoriesManager {

    private Logger log = LoggerFactory.getLogger(CategoriesManager.class);

    private HibernateRepo<CategoriesEntity> repository;

    public CategoriesManager(){
        repository = new HibernateRepo<CategoriesEntity>();
    }

    public void createNewCategory(String name, Integer parentId) throws To4kaException {
        log.trace("Create category with name [%s] and parent id [%d]", name, parentId != null ? parentId : "null");
        CategoriesEntity category = new CategoriesEntity();
        category.setName(name);
        category.setParentId(parentId);
        try {
            repository.save(category);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new To4kaException("Failed to create category");
        }
    }

    public void createNewCategories(CategoriesEntity[] ctaegories) throws To4kaException {
        log.trace("Create new categories");
        try {
            repository.save(ctaegories);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new To4kaException("Failed to create category");
        }
    }

    public Collection<CategoriesEntity> getAllCategories() throws To4kaException {
        log.trace("Get all categories");
        String queryStr = "from CategoriesEntity";
        try {
            return repository.select(queryStr);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new To4kaException("Failed to get categories.", e);
        }
    }

    public CategoriesEntity getCategoryById(Integer id) throws To4kaException {
        log.trace("Get category with id [%d]", id);
        String queryStr = String.format("from CategoriesEntity where id=%d", id);
        try {
            return repository.selectOne(queryStr);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new To4kaException("Failed to get category.", e);
        }
    }

    public void removeCategoryById(Integer id) throws To4kaException {
        log.trace("Remove category with id [%d]", id);
        String queryStr = String.format("delete from CategoriesEntity where id=%d", id);
        try {
            repository.executeQuery(queryStr);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new To4kaException("Failed to remove category");
        }
    }
}
