package com.netriddle.spring_example.model.converter;

import com.netriddle.spring_example.config.ExampleAppProperties;
import com.netriddle.spring_example.model.dto.ServletRequestInfoDTO;
import com.netriddle.spring_example.model.po.RequestData;
import com.netriddle.spring_example.model.response.GetRequestDataResponse;
import com.netriddle.spring_example.model.response.RestResponse;
import com.netriddle.spring_example.util.Tools;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class MainConverter {

    private final Tools tools;
    private final ExampleAppProperties exampleAppProperties;

    public RestResponse retrieveRestResponseForRootPath(ServletRequestInfoDTO servletRequestInfoDTO){
        log.debug("Converter - Retrieve rest response for root path START with request -> {}", servletRequestInfoDTO.toString());

        RestResponse restResponse = new RestResponse();

        restResponse.setMessage("Service is ONLINE");
        restResponse.setDomain(exampleAppProperties.getName());
        restResponse.setDetailed("Called from -> " + servletRequestInfoDTO.getIp());
        restResponse.setTimestamp(tools.getInstant());

        log.debug("Converter -  Retrieve rest response for root path END with DTO -> {}", restResponse);
        return restResponse;
    }

    public ServletRequestInfoDTO retrieveServletRequestInfo(HttpServletRequest httpServletRequest){
        log.debug("Converter - Retrieve servlet request info START with request -> {}", httpServletRequest.toString());

        String ip = getHeader(httpServletRequest,"X-Forwarded-For");

        ServletRequestInfoDTO servletRequestInfoDTO = new ServletRequestInfoDTO();
        servletRequestInfoDTO.setIp(ip);

        log.debug("Converter - Retrieve servlet request info END with DTO -> {}", servletRequestInfoDTO);
        return servletRequestInfoDTO;
    }

    public RequestData fromServletRequestDtoToPO(ServletRequestInfoDTO servletRequestInfoDTO){
        RequestData requestData = new RequestData();

        requestData.setIp(servletRequestInfoDTO.getIp());
        requestData.setTimestamp(tools.getInstant());

        return  requestData;
    }

    public GetRequestDataResponse buildGetRequestDataResponse(List<RequestData> requestDataList, ServletRequestInfoDTO servletRequestInfoDTO){
        GetRequestDataResponse getRequestDataResponse = new GetRequestDataResponse();

        getRequestDataResponse.setRequestDataList(requestDataList);
//        getRequestDataResponse.setMessage("Service is ONLINE");
        getRequestDataResponse.setDomain(exampleAppProperties.getName());
//        getRequestDataResponse.setDetailed("Called from -> " + servletRequestInfoDTO.getIp());
        getRequestDataResponse.setTimestamp(tools.getInstant());
        return getRequestDataResponse;
    }

    private String getHeader(HttpServletRequest httpServletRequest, String header) {
        String ip = httpServletRequest.getHeader(header);

        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = httpServletRequest.getRemoteAddr();
        }

        return ip;
    }

}
