package com.example.cn.demoapplication.JpaController;

import com.example.cn.demoapplication.JpaController.service.IJpaService;
import com.example.cn.demoapplication.common.ResultBean;
import com.example.cn.demoapplication.common.User;
import com.example.cn.demoapplication.common.exception.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author huyo
 */
@RestController
@RequestMapping("jpaController")
public class JpaController {

    @Autowired
    private IJpaService service;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResultBean saveUser(@RequestBody User user) {
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setMessage(service.saveUser(user));
        } catch (SystemException e) {
            resultBean = new ResultBean(e);
        }
        return resultBean;
    }

    @PostMapping("/update")
    public ResultBean updateUser(@RequestBody User user) {
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setMessage(service.updateUser(user));
        } catch (SystemException e) {
            resultBean = new ResultBean(e);
        }
        return resultBean;
    }

    /**
     * 逻辑删除
     * @param uid
     * @return
     */
    @DeleteMapping("/delete")
    public ResultBean deleteUserById(@RequestParam Integer uid) {
        service.deleteUserByUid(uid);
        return new ResultBean();
    }

    /**
     * 根据id查询未删除用户的详细信息
     * @param uid
     * @return
     */
    @GetMapping("/queryDetail")
    public ResultBean query(@RequestParam Integer uid) {
        return new ResultBean(service.queryUserDetailByUid(uid));
    }

    /**
     * 用户名称模糊查询
     * @param name
     * @return
     */
    @GetMapping("/queryByName")
    public ResultBean queryByName(@RequestParam String name) {
        return  new ResultBean(service.queryByName(name));
    }

    /**
     * 校验用户名称是否存在
     * @param name
     * @return
     */
    @GetMapping("/check")
    public ResultBean checkNameExist(@RequestParam String name) {
        ResultBean resultBean = new ResultBean();
        resultBean.setMessage(service.checkUserNameExist(name)?"用户名称不存在":"用户名称存在");
        return resultBean;
    }
}
