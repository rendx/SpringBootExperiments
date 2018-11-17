package com.huawei.springbootdemo.controller;

import com.huawei.springbootdemo.domain.ServerSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GetController {

    private Map<Object, Object> params = new HashMap<>();

    @GetMapping(path = "/v1/page_user2")
    public Object pageUserV2(@RequestParam(defaultValue = "0", name = "page") int  from, int size){
        params.clear();
        params.put("from", from);
        params.put("size", size);
        System.out.println("热加载222");
        return params;
    }

    @GetMapping(path = "/v1/page_user1")
    public Object pageUserV1(@RequestParam(defaultValue = "0", name = "page") int  from, int size){
        params.clear();
        params.put("from", from);
        params.put("size", size);
        System.out.println("热加载1");
        return params;
    }

    @Autowired
    private ServerSettings serverSettings;

    @GetMapping(path = "/v1/test_properties")
    public Object testProperties(){

        return serverSettings;
    }

    @GetMapping(path = "/test/home")
    private Object apiTest(){
        params.clear();
        int i = 1/0;
        System.out.println("OK");
        return "OK";
    }
}
