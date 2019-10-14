package com.example.cn.demoapplication.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;

@RestController
@Api(value = "测试逻辑")
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("hello")
    @ApiOperation(value = "返回字符串")
    public String doHello() {
        return "hello world yeah";
    }

    @PostMapping("sayHello/{text}")
    @ApiOperation(value = "入参逻辑判断")
    public String sayHello(@PathVariable("text") String text) throws Exception {
        /*Field field = text.getClass().getDeclaredField("");
        field.setAccessible(true);
        field.set(text, "asd");*/

        if (text != null || !text.trim().isEmpty()) {
            System.out.println("参数：" + text);
        }

        ArrayList list = new ArrayList();
        if (list.isEmpty() && CollectionUtils.isEmpty(list)) {
            // list.isEmpty() 判断集合是否是一个空集合 size == 0 ，前提是集合 != null
            // CollectionUtils.isEmpty(list) 判断集合是否==null，如果!=null，则集合是否为空
            list.clear();
        }

        return text;
    }

    /**
     * 在某类中加入异常处理注解
     * 只能处理该类的异常
     * 作用范围为该类
     * @param ex
     * @return
     */
    @ExceptionHandler
    public String doError(Exception ex) {
        ex.printStackTrace();
        System.out.println(ex.getMessage());
        return ex.getMessage();
    }
}
