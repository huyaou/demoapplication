package com.example.cn.demoapplication.common.emmun;

import com.example.cn.demoapplication.common.ResultBean;

/**
 * @program: demoapplication
 * @author: 大企业业务部 huyaou
 * @date: 2019年10月21日 10:21
 * @description: 接口形式的单例
 */
public enum Singleton implements MySingleton {
    INSTANCE {
        @Override
        public ResultBean doSomething() {
            return new ResultBean();
        }
    };

    public static MySingleton getInstance() {
        return Singleton.INSTANCE;
    }
}
