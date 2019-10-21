package com.example.cn.demoapplication.common.emmun;

/**
 * @program: demoapplication
 * @author: 大企业业务部 huyaou
 * @date: 2019年10月21日 10:28
 * @description: 内部枚举类形式-构造方法中实例化对象
 */
public class EnumSingleton {

    private EnumSingleton(){}

    public static EnumSingleton getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;
        private EnumSingleton singleton;

        Singleton() {
            singleton = new EnumSingleton();
        }

        public EnumSingleton getInstance() {
            return singleton;
        }
    }
}
