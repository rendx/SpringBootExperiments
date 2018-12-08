package com.huawei.springbootdemo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

//@Component
public class TaskDemo {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd: HH:mm:ss");

    @Scheduled(fixedRate = 2000L)
    public void executeTask() {
        System.out.println("Running task " + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void executeTaskWithCronExpression() {
        System.out.println("Running cron task " + dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 3000L)
    public void executeTaskWithFixedDelay() throws InterruptedException {
        Thread.sleep(4000L);
        System.out.println("Running task with fixed delay " + dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelayString = "3000")
    public void executeTaskWithFixedDelayString() throws InterruptedException {
        Thread.sleep(4000L);
        System.out.println("Running task with fixed delay " + dateFormat.format(new Date()));
    }
}
