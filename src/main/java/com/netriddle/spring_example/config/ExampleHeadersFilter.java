package com.netriddle.spring_example.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ExampleHeadersFilter extends OncePerRequestFilter {
    private static final String HEADER_APP_KEY_NAME = "X-APP-KEY";

    @Autowired
    ExampleSecurityProperties exampleSecurityProperties;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String apiKey = request.getHeader(HEADER_APP_KEY_NAME);

        if (apiKey == null || !exampleSecurityProperties.getLicensedApps().contains(apiKey)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        filterChain.doFilter(request, response);
    }
}
