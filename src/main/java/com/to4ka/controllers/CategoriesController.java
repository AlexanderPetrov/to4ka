package com.to4ka.controllers;

import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import com.to4ka.entities.CategoriesEntity;
import com.to4ka.managers.CategoriesManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by User on 2/18/2018.
 */
@RestController
public class CategoriesController {


    @RequestMapping("/addCategory")
    public CategoriesEntity addCategory(@RequestParam(value="name")String name,
                            @RequestParam(value = "parentId", required = false)Integer parentId){
        System.out.println(String.format("Create new category with name [%s]", name));

        CategoriesEntity category = CategoriesManager.createNewCategory(name, parentId);
        return category;
    }

    @RequestMapping("/getCategories")
    public Set<CategoriesEntity> getCategories(){
        Set<CategoriesEntity> categories = CategoriesManager.getAllCategories();
        return  categories;
    }

    @RequestMapping("/getCategory")
    public CategoriesEntity getCategory(@RequestParam(value = "id", required=false) Integer id){
        CategoriesEntity categories = CategoriesManager.getCategoryById(id);
        return  categories;
    }

    @RequestMapping("/removeCategory")
    public Boolean removeCategory(@RequestParam(value = "id") Integer id) throws Throwable {
            Boolean result = CategoriesManager.removeCategoryById(id);
        return  result;
    }
}
