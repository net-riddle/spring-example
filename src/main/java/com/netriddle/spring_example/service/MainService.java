package com.netriddle.spring_example.service;

import com.netriddle.spring_example.model.converter.MainConverter;
import com.netriddle.spring_example.model.response.RestResponse;
import com.netriddle.spring_example.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MainService {

    @Autowired
    MainConverter mainConverter;

    public RestResponse rootPathService(){
        return mainConverter.retrieveRestResponseForRootPath();
    }
}
