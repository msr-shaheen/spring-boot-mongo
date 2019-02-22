package com.shaheen.msr.springmongo.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class CustomAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        Map<String, String> headersInfo = getHeadersInfo(httpServletRequest);
        log.info("APP Intercepter : {}", headersInfo.toString());

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }


    private Map<String, String> getHeadersInfo(HttpServletRequest httpServletRequest) {
        HashMap map = new HashMap();
        Enumeration headerNames = httpServletRequest.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = httpServletRequest.getHeader(key);
            map.put(key, value);
        }

        return map;
    }

}
