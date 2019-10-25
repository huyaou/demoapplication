package com.example.cn.demoapplication.JpaController.service;

import com.example.cn.demoapplication.common.User;

import java.util.List;

/**
 * user操作接口
 * @author huyo
 */
public interface IJpaService {
    /**
     * 保存user
     * @param user
     * @return
     */
    String saveUser(User user);

    /**
     * 修改user
     * @param user
     * @return
     */
    String updateUser(User user);

    /**
     * 根据id逻辑删除user
     * @param uid
     */
    void deleteUserByUid(Integer uid);

    /**
     * 查询user详情
     * @param uid
     * @return
     */
    User queryUserDetailByUid(Integer uid);

    /**
     * 用户名称模糊查询
     * @param name
     * @return
     */
    List<User> queryByName(String name);

    /**
     * 校验用户名称是否存在
     * @param name
     * @return
     */
    boolean checkUserNameExist(String name);
}
