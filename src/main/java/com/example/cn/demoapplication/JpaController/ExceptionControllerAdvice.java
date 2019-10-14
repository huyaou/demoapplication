package com.example.cn.demoapplication.JpaController;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异常处理的不同注解实现
 */
@ControllerAdvice(basePackages = "", value = "", annotations = RestController.class)
@ResponseBody
public class ExceptionControllerAdvice {
}
