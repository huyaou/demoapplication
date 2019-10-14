package com.example.cn.demoapplication.ThreadPool;

import java.util.concurrent.Callable;

public class MyThread implements Callable {

    @Override
    public Object call() throws Exception {

        return "test thread!!";
    }
}
