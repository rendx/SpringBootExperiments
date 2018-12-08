package com.huawei.springbootdemo.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * 异步任务业务类
 */
@Component
public class AsyncTask {

    @Async
    public void task1() throws InterruptedException {
        long beginTime = System.currentTimeMillis();
        Thread.sleep(2000L);
        long endTime = System.currentTimeMillis();
        System.out.println("任务1已完成，耗时：" + (endTime - beginTime) / 1000 + "秒");
    }

    @Async
    public void task2() throws InterruptedException {
        long beginTime = System.currentTimeMillis();
        Thread.sleep(2000L);
        long endTime = System.currentTimeMillis();
        System.out.println("任务2已完成，耗时：" + (endTime - beginTime) / 1000 + "秒");
    }

    @Async
    public void task3() throws InterruptedException {
        long beginTime = System.currentTimeMillis();
        Thread.sleep(2000L);
        long endTime = System.currentTimeMillis();
        System.out.println("任务3已完成，耗时：" + (endTime - beginTime) / 1000 + "秒");
    }

    @Async
    public void task4() throws InterruptedException {
        long beginTime = System.currentTimeMillis();
        Thread.sleep(2000L);
        long endTime = System.currentTimeMillis();
        System.out.println("任务4已完成，耗时：" + (endTime - beginTime) / 1000 + "秒");
    }

    @Async
    public Future<String> task5() throws InterruptedException {
        long beginTime = System.currentTimeMillis();
        Thread.sleep(3000L);
        long endTime = System.currentTimeMillis();
        System.out.println("任务5已完成，耗时：" + (endTime - beginTime) / 1000 + "秒");
        return new AsyncResult<>("任务5");
    }

    @Async
    public Future<String> task6() throws InterruptedException {
        long beginTime = System.currentTimeMillis();
        Thread.sleep(7000L);
        long endTime = System.currentTimeMillis();
        System.out.println("任务6已完成，耗时：" + (endTime - beginTime) / 1000 + "秒");
        return new AsyncResult<>("任务6");
    }
    
    @Async
    public Future<String> task7() throws InterruptedException {
        long beginTime = System.currentTimeMillis();
        Thread.sleep(8000L);
        long endTime = System.currentTimeMillis();
        System.out.println("任务7已完成，耗时：" + (endTime - beginTime) / 1000 + "秒");
        return new AsyncResult<>("任务7");
    }
}
