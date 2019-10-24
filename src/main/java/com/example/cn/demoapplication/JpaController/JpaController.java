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
        resultBean.setMessage(service.saveUser(user));
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
}
