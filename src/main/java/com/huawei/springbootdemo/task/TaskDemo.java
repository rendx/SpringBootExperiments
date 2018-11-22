package com.huawei.springbootdemo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TaskDemo {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd: HH:mm:ss");

    @Scheduled(fixedRate = 2000)
    public void executeTask(){
        System.out.println("Running task "+ dateFormat.format(new Date()));
    }
}
