package com.example.cn.demoapplication.test;

import com.example.cn.demoapplication.common.User;
import org.junit.Test;

/**
 * @program: demoapplication
 * @description: 测试缓存
 * @author: huyaou
 * @create: 2019-10-14 16:00
 */
public class TestCache extends BaseTest {

    @Override
    @Test
    public void test() {
        User user = new User();
        user.setUid(123);
        user.setName("hu");
        user.setAge(12);

        postRequest("/cache/saveUser", user);
    }

    @Test
    public void testqueryByName() {
        getRequest("/cache/queryUserByName?name=hu&uid=12", null);
    }
}
