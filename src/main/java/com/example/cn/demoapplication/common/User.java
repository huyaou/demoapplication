package com.example.cn.demoapplication.common;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//当不指定任何参数时，默认会使用非静态和非transient型字段来生成

//@AllArgsConstructor
/*@Component
@ConfigurationProperties(prefix = "user")*/
public class User implements Serializable {

    @EqualsAndHashCode.Include
    private Integer uid;

    @EqualsAndHashCode.Include
    private String name;

    private Integer age;

    private String address;

    private String phoneNum;

    public User(Integer uid, String name) {
        this.uid = uid;
        this.name = name;
    }
}
