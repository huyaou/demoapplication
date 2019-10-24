package com.example.cn.demoapplication.JpaController.dao;


import com.example.cn.demoapplication.common.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface JpaDao extends JpaRepository<User, Integer> {

    /**
     * 用户名称查询
     * nativeQuery = true 原生sql查询
     * @param name
     * @return
     */
    @Query(value = "select * from USER_INFO u where u.USER_NAME = :name", nativeQuery = true)
    User queryByName(@Param("name") String name);

    /**
     * 当语句中没有nativeQuery = true条件时，hibernate会自动映射，此时sql语句中表名使用的是类名，字段使用的是类的属性
     * 当语句中有nativeQuery = true条件时，设定使用原生的sql，就是直接使用value中的sql语句查询，此时sql语句是原生、标准的
     * 不需要映射，所以要使用数据库的表名和字段名称
     * 在执行修改或者删除语句时需要加上事务的注解
     * @param uid
     */
    @Transactional
    @Modifying
    @Query(value = "update User u set u.del = 1 where u.uid=?1")
    void updateByUid(Integer uid);

}
