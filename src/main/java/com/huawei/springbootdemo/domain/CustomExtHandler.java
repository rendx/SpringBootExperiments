package com.huawei.springbootdemo.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExtHandler {
    private static final Logger logger = LoggerFactory.getLogger(CustomExtHandler.class);
    @ExceptionHandler(value = Exception.class)
    Object handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        /* SSA.ExtExample.0001是魔法值 */
        logger.error("Exception happened when haddle request, uri: " + request.getRequestURI());
        logger.error("Exception details: " , e);
        map.put("code", "SSA.ExtExample.0001");
        map.put("url", request.getRequestURL());
        map.put("msg", e.getMessage());
        return map;
    }
}
