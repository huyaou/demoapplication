package com.example.cn.demoapplication.JpaController.dao;


import com.example.cn.demoapplication.common.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaDao extends JpaRepository<User, Integer> {

    /**
     * 用户名称查询
     * nativeQuery = true 原生sql查询
     * @param name
     * @return
     */
    @Query(value = "select * from USER_INFO u where u.USER_NAME = :name", nativeQuery = true)
    User queryByName(@Param("name") String name);

}
