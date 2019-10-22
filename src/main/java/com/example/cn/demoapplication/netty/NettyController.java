package com.example.cn.demoapplication.netty;

import com.example.cn.demoapplication.common.ResultBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demoapplication
 * @author: 大企业业务部 huyaou
 * @date: 2019年10月22日 10:19
 * @description: netty 测试控制器
 */
@RestController
@RequestMapping("netty")
public class NettyController {

    @PostMapping("/send")
    public ResultBean sendMessage() {
        return new ResultBean();
    }
}
