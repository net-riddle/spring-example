package com.netriddle.spring_example.controller;

import com.netriddle.spring_example.model.converter.MainConverter;
import com.netriddle.spring_example.model.dto.ServletRequestInfoDTO;
import com.netriddle.spring_example.model.response.RestResponse;
import com.netriddle.spring_example.service.MainService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    MainService mainService;
    @Autowired
    MainConverter mainConverter;

    @GetMapping("/")
    public ResponseEntity<Object> rootPath(HttpServletRequest httpServletRequest){
        ServletRequestInfoDTO servletRequestInfoDTO = mainConverter.retrieveServletRequestInfo(httpServletRequest);
        RestResponse restResponse = mainService.rootPathService(servletRequestInfoDTO);
        return new ResponseEntity<>(restResponse,HttpStatus.OK);
    }
}
