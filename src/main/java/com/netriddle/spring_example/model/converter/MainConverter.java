package com.netriddle.spring_example.model.converter;

import com.netriddle.spring_example.model.response.RestResponse;
import com.netriddle.spring_example.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainConverter {

    @Autowired
    Tools tools;

    public RestResponse retrieveRestResponseForRootPath(){
        RestResponse restResponse = new RestResponse();
        restResponse.setMessage("ONLINE");
        restResponse.setDomain("spring-example");
        restResponse.setDetailed("Service is Online");
        restResponse.setTimestamp(tools.getInstant());
        return restResponse;
    }
}
