package com.to4ka.managers;

import com.to4ka.entities.CategoriesEntity;
import com.to4ka.entities.ProductsEntity;
import com.to4ka.util.HibernateRepo;

/**
 * Created by User on 2/24/2018.
 */
public class ProductsManager {

    private final HibernateRepo<ProductsEntity> repository;

    public ProductsManager(){
        repository = new HibernateRepo<ProductsEntity>();
    }

    public void createNewProduct(String name, Integer categoryId, String description) throws Exception {
        CategoriesEntity category = new CategoriesEntity();
        category.setId(categoryId);

        ProductsEntity product = new ProductsEntity();
        product.setName(name);
        product.setCategory(category);
        product.setDescription(description);
        repository.save(product);
    }
}
