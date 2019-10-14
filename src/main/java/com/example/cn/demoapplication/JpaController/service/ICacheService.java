package com.example.cn.demoapplication.JpaController.service;

import com.example.cn.demoapplication.common.User;

public interface ICacheService {
    Integer testCache(Integer uid);

    void delete(Integer uid);

    Integer save(Integer uid);

    Object saveUser(User user);

    User queryUserByName(String name, Integer uid);
}
