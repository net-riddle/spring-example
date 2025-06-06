package com.netriddle.spring_example.repository;

import com.netriddle.spring_example.model.converter.MainConverter;
import com.netriddle.spring_example.model.dto.ServletRequestInfoDTO;
import com.netriddle.spring_example.model.po.RequestData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Repository
public class MainRepository {

    private List<RequestData> requestDataStored = new ArrayList<>();
    private final MainConverter mainConverter;

    public void storeRequestData(ServletRequestInfoDTO servletRequestInfoDTO){
        log.debug("Repository - Store request data: START");
        RequestData requestData = mainConverter.fromServletRequestDtoToPO(servletRequestInfoDTO);
        requestDataStored.add(requestData);
        log.debug("Repository - Store request data: DONE");
    }
    public List<RequestData> retrieveRequestData(){
        log.debug("Repository - Retrieve request data -> {}", requestDataStored);
        return requestDataStored;
    }
}
