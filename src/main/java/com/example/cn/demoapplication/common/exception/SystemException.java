package com.example.cn.demoapplication.common.exception;

/**
 * @program: demoapplication
 * @author: 大企业业务部 huyaou
 * @date: 2019年10月18日 14:36
 * @description: 自定义异常类
 */
public class SystemException extends BaseException {

    public SystemException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }
}
