package com.example.cn.demoapplication.JpaController;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局处理异常
 */
@RestControllerAdvice(annotations = RestController.class)
public class ExceptionRestControllerAdvice {

    /**
     * 可定制处理某类的异常
     * 或者所有异常的处理逻辑相同
     * @param ex
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    public Object handler(Exception ex) {
        // do something
        return null;
    }

}
