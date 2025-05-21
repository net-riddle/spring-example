package com.netriddle.spring_example.controller;

import com.netriddle.spring_example.model.converter.MainConverter;
import com.netriddle.spring_example.model.dto.ServletRequestInfoDTO;
import com.netriddle.spring_example.model.response.GetRequestDataResponse;
import com.netriddle.spring_example.model.response.RestResponse;
import com.netriddle.spring_example.service.MainService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MainController {

    private final MainService mainService;
    private final MainConverter mainConverter;

    @GetMapping("/")
    public ResponseEntity<Object> rootPath(HttpServletRequest httpServletRequest){
        log.info("Controller - Root path: START");
        ServletRequestInfoDTO servletRequestInfoDTO = mainConverter.retrieveServletRequestInfo(httpServletRequest);
        RestResponse restResponse = mainService.rootPathService(servletRequestInfoDTO);
        log.info("Controller - Root path: DONE");
        return new ResponseEntity<>(restResponse,HttpStatus.OK);
    }

    @GetMapping("/request-data")
    public ResponseEntity<Object> getRequestData(HttpServletRequest httpServletRequest){
        log.info("Controller - Get request data: START");
        ServletRequestInfoDTO servletRequestInfoDTO = mainConverter.retrieveServletRequestInfo(httpServletRequest);
        GetRequestDataResponse getRequestDataResponse = mainService.getRequestDataService(servletRequestInfoDTO);
        log.info("Controller - Get request data: DONE");
        return new ResponseEntity<>(getRequestDataResponse,HttpStatus.OK);
    }
}
