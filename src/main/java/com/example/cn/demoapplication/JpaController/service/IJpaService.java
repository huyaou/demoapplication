package com.example.cn.demoapplication.JpaController.service;

import com.example.cn.demoapplication.common.User;

public interface IJpaService {
    String saveUser(User user);

    String updateUser(User user);
}
