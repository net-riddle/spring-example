package com.netriddle.spring_example.repository;

import com.netriddle.spring_example.model.converter.MainConverter;
import com.netriddle.spring_example.model.dto.ServletRequestInfoDTO;
import com.netriddle.spring_example.model.po.RequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MainRepository {

    private List<RequestData> requestDataStored = new ArrayList<>();

    @Autowired
    MainConverter mainConverter;

    public void storeRequestData(ServletRequestInfoDTO servletRequestInfoDTO){
        RequestData requestData = mainConverter.fromServletRequestDtoToPO(servletRequestInfoDTO);
        requestDataStored.add(requestData);
    }
    public List<RequestData> retrieveRequestData(){
        return requestDataStored;
    }
}
