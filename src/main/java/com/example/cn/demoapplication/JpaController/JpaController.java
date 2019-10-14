package com.example.cn.demoapplication.JpaController;

import com.example.cn.demoapplication.JpaController.service.IJpaService;
import com.example.cn.demoapplication.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jpaController")
public class JpaController {

    @Autowired
    private IJpaService service;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@RequestBody User user) {
        service.saveUser(user);
        return "success";
    }
}
