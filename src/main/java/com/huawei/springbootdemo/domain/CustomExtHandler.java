package com.huawei.springbootdemo.domain;

import com.huawei.springbootdemo.exception.MyExcepiton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExtHandler {
    private static final Logger logger = LoggerFactory.getLogger(CustomExtHandler.class);

    @ExceptionHandler(Exception.class)
    Object handleException(Exception e, HttpServletRequest request) {
        logger.error("url {} msg {}", request.getRequestURL(), e.getMessage());

        Map<String, Object> map = new HashMap<>();
        map.put("code", 100);
        map.put("msg", e.getMessage());
        map.put("url", request.getRequestURL());
        return map;
    }

    @ExceptionHandler(MyExcepiton.class)
    Object handleMyException(Exception ex, HttpServletRequest request) {
        logger.error("url {} msg {}", request.getRequestURL(), ex.getMessage(), ex);
/*        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error.html");
        modelAndView.addObject("msg", ex.getMessage());
        return modelAndView;*/
        Map<String, Object> map = new HashMap<>();
        map.put("code", 500);
        map.put("msg", ex.getMessage());
        map.put("url", request.getRequestURL());
        return map;
    }

}
