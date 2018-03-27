package com.to4ka.controllers;

import com.to4ka.auxiliary.To4kaResponse;
import com.to4ka.exceptions.To4kaException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by User on 3/8/2018.
 */
public class ControllerBase {

    Logger log = LoggerFactory.getLogger(ControllerBase.class);

    @RequestMapping(value = "/error")
    public ResponseEntity<?> errorHandler(Throwable ex) {
        log.error(ex.getMessage());
        return ResponseEntity.ok().body(To4kaResponse.error(ex.getMessage()));
    }

//    @ExceptionHandler(To4kaException.class)
//    public ResponseEntity<?> errorHandle(To4kaException ex) {
//        return ResponseEntity.badRequest().body(To4kaResponse.error(ex.getMessage()));
//    }
}
