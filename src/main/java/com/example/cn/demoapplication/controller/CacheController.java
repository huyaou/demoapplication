package com.example.cn.demoapplication.controller;

import com.example.cn.demoapplication.JpaController.service.ICacheService;
import com.example.cn.demoapplication.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private ICacheService service;

    @GetMapping("/testCache/{uid}")
    public Integer test(@PathVariable("uid") Integer uid) {
        return service.testCache(uid);
    }

    @DeleteMapping("/delete/{uid}")
    public String delete(@PathVariable("uid") Integer uid) {
        service.delete(uid);
        return "success";
    }

    @PostMapping("/saveCache")
    public Integer save(@RequestBody User user) {
        return service.save(user.getUid());
    }

    @PostMapping("/saveUser")
    public Object saveUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @GetMapping("/queryUserByName")
    public User queryUserByName(@RequestParam("name") String name, @RequestParam("uid") Integer uid) {
        return service.queryUserByName(name, uid);
    }
}
