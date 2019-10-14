package com.example.cn.demoapplication.JpaController.service.impl;

import com.example.cn.demoapplication.DateUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;

/**
 * 定时任务
 */
@Component
public class SchedulTask {

    /**
     * 定时任务方法无入参
     *
     * cron 表达式 [秒] [分] [小时] [日] [月] [周] [年]
     * 年是可省略的
     * 使用cron表达式时，不可与initialDelay一起使用
     * @return
     */
    @Scheduled(cron = "0 0 2 1 * ?")
    public Object doSomething() {
        System.out.println("cron...");
        return null;
    }

    /**
     * initialDelay 初始延迟
     * fixedDelay 上一次执行完成后经过延迟后再执行
     */
    //@Scheduled(initialDelay = 1230, fixedDelay = 1000)
    public void schedulDelay() throws InterruptedException {
        Thread.sleep(1200);
        System.out.println("fixedDelay..." + Thread.currentThread().getName() + "-" + System.currentTimeMillis());
    }

    /**
     * fixedRate 上一次开始执行经过延迟后再执行
     */
    //@Scheduled(initialDelay = 2130, fixedRate = 2000)
    public void schedulRate() throws InterruptedException {
        Thread.sleep(4400);
        System.out.println("fixedRate..." + Thread.currentThread().getName() + "-" + System.currentTimeMillis());
    }

}
