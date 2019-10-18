package com.example.cn.demoapplication.controller;

import com.example.cn.demoapplication.JpaController.service.ICacheService;
import com.example.cn.demoapplication.common.ResultBean;
import com.example.cn.demoapplication.common.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: demoapplication
 * @description: cache 测试用例
 * @author: huyaou
 * @create: 2019-10-14 11:05
 */
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private ICacheService service;

    @GetMapping("/testCache/{uid}")
    public ResultBean test(@PathVariable("uid") Integer uid) {
        return new ResultBean(service.testCache(uid));
    }

    @GetMapping("/delete/{uid}")
    public ResultBean delete(@PathVariable("uid") Integer uid) {
        service.delete(uid);
        return new ResultBean();
    }

    @PostMapping("/saveCache")
    public ResultBean save(@RequestBody User user) {
        return new ResultBean(service.save(user.getUid()));
    }

    @PostMapping("/saveUser")
    public ResultBean saveUser(@RequestBody User user) {
        return new ResultBean(service.saveUser(user));
    }

    @GetMapping("/queryUserByName")
    public ResultBean queryUserByName(@RequestParam("name") String name, @RequestParam("uid") Integer uid) {
        User user = service.queryUserByName(name, uid);
        ResultBean resultBean = new ResultBean();
        if (user == null) {
            resultBean.setMessage("未查询到用户");
            return resultBean;
        }
        resultBean.getData().add(user);
        return resultBean;
    }
}
