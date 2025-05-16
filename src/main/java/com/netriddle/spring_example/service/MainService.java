package com.netriddle.spring_example.service;

import com.netriddle.spring_example.model.response.RestResponse;
import com.netriddle.spring_example.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MainService {
    @Autowired
    Tools tools;

    public RestResponse rootPathService(){
        RestResponse restResponse = new RestResponse();
        restResponse.setMessage("ONLINE");
        restResponse.setDomain("spring-example");
        restResponse.setDetailed("Service is Online");
        restResponse.setTimestamp(tools.getInstant());
        return restResponse;
    }
}
