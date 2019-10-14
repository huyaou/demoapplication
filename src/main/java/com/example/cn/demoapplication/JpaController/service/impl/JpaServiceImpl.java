package com.example.cn.demoapplication.JpaController.service.impl;

import com.example.cn.demoapplication.JpaController.dao.JpaDao;
import com.example.cn.demoapplication.JpaController.service.IJpaService;
import com.example.cn.demoapplication.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class JpaServiceImpl implements IJpaService {

    /*@Autowired
    private User user1;*/

    @Override
    public void saveUser(User user) {
        System.out.println(user.getUid());
        System.out.println(user.getName());

        /*LinkedBlockingQueue queue = new LinkedBlockingQueue();
        ExecutorService executor = new ThreadPoolExecutor(10, 200, 60, TimeUnit.SECONDS, queue, new ThreadPoolExecutor.AbortPolicy());
        */

        /*User user2 = User.builder().build();
        User user3 = User.builder()
                .uid(12)
                .name("asd")
                .age(2)
                .address("dsss")
                .phoneNum("w")
                .build();*/
    }
}
