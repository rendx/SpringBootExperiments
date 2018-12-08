package com.huawei.springbootdemo.controller;

import com.huawei.springbootdemo.domain.JsonData;
import com.huawei.springbootdemo.domain.ServerSettings;
import com.huawei.springbootdemo.exception.MyExcepiton;
import com.huawei.springbootdemo.task.AsyncTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

@RestController
public class GetController {

    private static final Logger logger = LoggerFactory.getLogger(GetController.class);

    private final AsyncTask asyncTask;

    private Map<Object, Object> params = new HashMap<>();

    @Autowired
    public GetController(AsyncTask asyncTask, ServerSettings serverSettings) {
        this.asyncTask = asyncTask;
        this.serverSettings = serverSettings;
    }

    @GetMapping(path = "/v1/page_user2")
    public Object pageUserV2(@RequestParam(defaultValue = "0", name = "page") int from, int size) {
        params.clear();
        params.put("from", from);
        params.put("size", size);
        System.out.println("热加载222");
        return params;
    }

    @GetMapping(path = "/v1/page_user1")
    public Object pageUserV1(@RequestParam(defaultValue = "0", name = "page") int from, int size) {
        params.clear();
        params.put("from", from);
        params.put("size", size);
        System.out.println("热加载1");
        return params;
    }

    private final ServerSettings serverSettings;

    @GetMapping(path = "/api/test_properties")
    public Object testProperties() {

        return serverSettings;
    }

    @GetMapping(path = "/test/home")
    private Object apiTest() {
        params.clear();
        int i = 1 / 0;
        System.out.println("OK");
        return "OK";
    }

    @RequestMapping(value = "/v1/exception", method = RequestMethod.GET)
    private Object testException() {
        throw new MyExcepiton("500", "MyExcepiton异常");
    }


    @GetMapping(path = "/async_task")
    public JsonData execTask() throws InterruptedException {
        Long beginTime = System.currentTimeMillis();

        asyncTask.task1();
        asyncTask.task2();
        asyncTask.task3();
        asyncTask.task4();

        Long endTime = System.currentTimeMillis();
        System.out.println("异步任务1总耗时：" + (beginTime - endTime) / 1000 + "秒");

        beginTime = System.currentTimeMillis();
        Future<String> task5 = asyncTask.task5();
        Future<String> task6 = asyncTask.task6();
        Future<String> task7 = asyncTask.task7();

        for (; ; ) {
            if (task5.isDone() && task6.isDone() && task7.isDone()) {
                break;
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("异步任务2总耗时：" + (endTime - beginTime) / 1000 + "秒");
        return JsonData.buildSuccess();
    }


    @GetMapping(path = "/testlog")
    public JsonData testLog() {
        logger.debug("log test. ");
        logger.info("log test. ");
        logger.warn("log test. ");
        logger.error("log test. ");

        return JsonData.buildSuccess();
    }

}
