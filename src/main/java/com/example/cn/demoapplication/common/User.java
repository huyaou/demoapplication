package com.example.cn.demoapplication.common;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "USER_INFO")
public class User implements Serializable {

    @Id
    @Column(name = "USER_ID", nullable = false)
    /**
     * 主键生成策略
     * strategy
     */
    //@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "UserSeq")
    /**
     * 定义主键生成序列
     *
     */
    //@SequenceGenerator(name = "UserSeq", sequenceName = "user_seq", allocationSize = 1)
    private Integer uid;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "USER_AGE")
    private Integer age;

    @Column(name = "USER_ADDRESS")
    private String address;

    @Column(name = "USER_PHONE")
    private String phoneNum;

    @Column(name = "DEL_FLAG")
    private Integer del = 0;
    
    public User() {}

    public User(Integer uid, String name) {
        this.uid = uid;
        this.name = name;
    }
}
