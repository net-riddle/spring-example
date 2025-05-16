package com.netriddle.spring_example.model.converter;

import com.netriddle.spring_example.model.dto.ServletRequestInfoDTO;
import com.netriddle.spring_example.model.po.RequestData;
import com.netriddle.spring_example.model.response.RestResponse;
import com.netriddle.spring_example.util.Tools;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainConverter {

    @Autowired
    Tools tools;

    public RestResponse retrieveRestResponseForRootPath(ServletRequestInfoDTO servletRequestInfoDTO){
        RestResponse restResponse = new RestResponse();

        restResponse.setMessage("Service is ONLINE");
        restResponse.setDomain("spring-example");
        restResponse.setDetailed("Called from -> " + servletRequestInfoDTO.getIp());
        restResponse.setTimestamp(tools.getInstant());

        return restResponse;
    }

    public ServletRequestInfoDTO retrieveServletRequestInfo(HttpServletRequest httpServletRequest){
        String ip = getHeader(httpServletRequest,"X-Forwarded-For");

        ServletRequestInfoDTO servletRequestInfoDTO = new ServletRequestInfoDTO();
        servletRequestInfoDTO.setIp(ip);
        return servletRequestInfoDTO;
    }

    public RequestData fromServletRequestDtoToPO(ServletRequestInfoDTO servletRequestInfoDTO){
        RequestData requestData = new RequestData();

        requestData.setIp(servletRequestInfoDTO.getIp());
        requestData.setTimestamp(tools.getInstant());

        return  requestData;
    }

    private String getHeader(HttpServletRequest httpServletRequest, String header) {
        String ip = httpServletRequest.getHeader(header);

        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = httpServletRequest.getRemoteAddr();
        }

        return ip;
    }

}
