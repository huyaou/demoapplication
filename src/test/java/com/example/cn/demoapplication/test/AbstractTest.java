package com.example.cn.demoapplication.test;

import com.example.cn.demoapplication.DemoapplicationApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @program: demoapplication
 * @description: 测试抽象类
 * @author: huyaou
 * @create: 2019-10-14 15:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoapplicationApplication.class)
@WebAppConfiguration
public abstract class AbstractTest {

    @Autowired
    private WebApplicationContext context;

    protected MockMvc mockMvc;

    @Before
    public void setupMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @After
    public void after() {
        System.out.println("Test class end..........");
    }

    @Test
    public abstract void test();
}
