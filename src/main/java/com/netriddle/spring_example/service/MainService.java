package com.netriddle.spring_example.service;

import com.netriddle.spring_example.model.converter.MainConverter;
import com.netriddle.spring_example.model.dto.ServletRequestInfoDTO;
import com.netriddle.spring_example.model.po.RequestData;
import com.netriddle.spring_example.model.response.GetRequestDataResponse;
import com.netriddle.spring_example.model.response.RestResponse;
import com.netriddle.spring_example.repository.MainRepository;
import com.netriddle.spring_example.util.Tools;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MainService {

    private final MainConverter mainConverter;
    private final MainRepository mainRepository;

    public RestResponse rootPathService(ServletRequestInfoDTO servletRequestInfoDTO){
        log.debug("Service - Root path service: START");

        mainRepository.storeRequestData(servletRequestInfoDTO);
        RestResponse restResponse = mainConverter.retrieveRestResponseForRootPath(servletRequestInfoDTO);

        log.debug("Service - Root path service DONE with response -> {}", restResponse);
        return restResponse;
    }

    public GetRequestDataResponse getRequestDataService(ServletRequestInfoDTO servletRequestInfoDTO){
        log.debug("Service - Get request data service: START");

        mainRepository.storeRequestData(servletRequestInfoDTO);
        List<RequestData> requestDataList = mainRepository.retrieveRequestData();
        GetRequestDataResponse getRequestDataResponse = mainConverter.buildGetRequestDataResponse(requestDataList,servletRequestInfoDTO);

        log.debug("Service - Get request data DONE with response -> {}", getRequestDataResponse);
        return getRequestDataResponse;
    }
}
