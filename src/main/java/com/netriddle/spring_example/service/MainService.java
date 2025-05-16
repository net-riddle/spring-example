package com.netriddle.spring_example.service;

import com.netriddle.spring_example.model.converter.MainConverter;
import com.netriddle.spring_example.model.dto.ServletRequestInfoDTO;
import com.netriddle.spring_example.model.po.RequestData;
import com.netriddle.spring_example.model.response.RestResponse;
import com.netriddle.spring_example.repository.MainRepository;
import com.netriddle.spring_example.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MainService {

    @Autowired
    MainConverter mainConverter;
    @Autowired
    MainRepository mainRepository;

    public RestResponse rootPathService(ServletRequestInfoDTO servletRequestInfoDTO){
        mainRepository.storeRequestData(servletRequestInfoDTO);
        return mainConverter.retrieveRestResponseForRootPath(servletRequestInfoDTO);
    }
}
