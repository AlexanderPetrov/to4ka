package com.to4ka.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;
import com.to4ka.auxiliary.To4kaRequest;
import com.to4ka.auxiliary.To4kaResponse;
import com.to4ka.entities.CategoriesEntity;
import com.to4ka.exceptions.To4kaException;
import com.to4ka.managers.CategoriesManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.jws.WebMethod;

/**
 * Created by User on 2/18/2018.
 */
@RestController
@ControllerAdvice
@RequestMapping("/categories")
public class CategoriesController extends ControllerBase{

    private CategoriesManager categoriesManager = new CategoriesManager();
    private Logger log = LoggerFactory.getLogger(CategoriesController.class);

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> addCategory(@RequestBody ModelMap requestMap) throws To4kaException {
        log.trace("Add category request");
        JSONObject request = new JSONObject(requestMap);
        String categoriesJsonArrStr = request.getJSONArray("requestBody").toString();

        Gson gson = new Gson();
        CategoriesEntity[] categoriesEntities = gson.fromJson(categoriesJsonArrStr, CategoriesEntity[].class);
        categoriesManager.createNewCategories(categoriesEntities);

        return ResponseEntity.ok().body(To4kaResponse.success().getResponse());
    }

    @RequestMapping(value = "/{category_id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> getCategory(@PathVariable(name = "category_id") int categoryId) throws To4kaException {
        log.trace("Get category request");
        CategoriesEntity category = categoriesManager.getCategoryById(categoryId);
        To4kaResponse response = new To4kaResponse();
        response.appendData("category", category);

        return ResponseEntity.ok().body(response.getResponse());
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> getAllCategories() throws To4kaException {
        log.trace("Get all categories request");
        Collection<CategoriesEntity> categories = categoriesManager.getAllCategories();
        To4kaResponse<CategoriesEntity> response = new To4kaResponse<CategoriesEntity>();
        response.appendData("categories", categories);

        return ResponseEntity.ok().body(response.getResponse());
    }

    @RequestMapping(value = "/remove/{category_id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<String> removeCategory(@PathVariable(value = "category_id") Integer category_id) throws To4kaException {
        log.trace("Remove category request");
        categoriesManager.removeCategoryById(category_id);
        return ResponseEntity.ok().body(To4kaResponse.success().getResponse());
    }
}
