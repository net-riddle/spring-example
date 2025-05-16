package com.netriddle.spring_example.controller;

import com.netriddle.spring_example.model.response.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public ResponseEntity<Object> rootPath(){
        return new ResponseEntity<>(new RestResponse(),HttpStatus.OK);
    }
}
