package com.example.cn.demoapplication.common.emmun;

/**
 * @program: demoapplication
 * @author: 大企业业务部 huyaou
 * @date: 2019年10月21日 10:34
 * @description: 内部枚举类形式-枚举常量的值即为对象实例
 */
public class MyEnumSingleton {
    private MyEnumSingleton() {}

    public static MyEnumSingleton getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE(new MyEnumSingleton());
        private MyEnumSingleton singleton;

        Singleton(MyEnumSingleton singleton) {
            this.singleton = singleton;
        }

        public MyEnumSingleton getInstance() {
            return singleton;
        }
    }
}
