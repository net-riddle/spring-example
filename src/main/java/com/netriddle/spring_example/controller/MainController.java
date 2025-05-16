package com.netriddle.spring_example.controller;

import com.netriddle.spring_example.model.response.RestResponse;
import com.netriddle.spring_example.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    MainService mainService;

    @GetMapping("/")
    public ResponseEntity<Object> rootPath(){
        RestResponse restResponse = mainService.rootPathService();
        return new ResponseEntity<>(restResponse,HttpStatus.OK);
    }
}
