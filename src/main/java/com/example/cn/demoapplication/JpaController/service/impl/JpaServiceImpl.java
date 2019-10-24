package com.example.cn.demoapplication.JpaController.service.impl;

import com.example.cn.demoapplication.JpaController.dao.JpaDao;
import com.example.cn.demoapplication.JpaController.service.IJpaService;
import com.example.cn.demoapplication.common.User;
import com.example.cn.demoapplication.common.exception.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaServiceImpl implements IJpaService {

    @Autowired
    private JpaDao jpaDao;

    @Override
    public String saveUser(User user) {
        User user1 = jpaDao.queryByName(user.getName());
        if (user1 != null) {
            return "用户已存在";
        }
        jpaDao.save(user);
        return "添加成功";
    }

    @Override
    public String updateUser(User user) {
        Integer uid = user.getUid();
        if (uid == null) {
            throw new SystemException("1001", "用户id不能为空");
        }
        jpaDao.save(user);
        return "修改成功";
    }

    @Override
    public void deleteUserByUid(Integer uid) {
        jpaDao.updateByUid(uid);
    }
}
