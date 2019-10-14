package com.example.cn.demoapplication.test;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @program: demoapplication
 * @description: 测试基类
 * @author: huyaou
 * @create: 2019-10-14 15:54
 */
public abstract class BaseTest extends AbstractTest {

    protected static final String success = "success";

    protected JSONObject getRequest(String path, Object param) {
        return request("get", path, param);
    }

    protected JSONObject postRequest(String path, Object param) {
        return request("post", path, param);
    }

    private JSONObject request(String method, String path, Object param) {
        JSONObject responseResult = null;
        MvcResult result;// 返回执行请求的结果
        try {
            result = mockMvc.perform(getMockHttpServletRequestBuilder(method, path, param))
                    .andExpect(status().isOk())// 模拟向testRest发送get请求
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
                    .andReturn();
            String responseResultStr = result.getResponse().getContentAsString();
            responseResult = JSONObject.parseObject(responseResultStr);
            System.out.println("-----------------请求结果打印开始：-------------");
            System.out.println(responseResultStr);
            System.out.println("-----------------请求结果打印结束：-------------");
        } catch (Exception e) {
            System.out.println("请求异常");
            e.printStackTrace();
        }
        return responseResult;
    }

    private MockHttpServletRequestBuilder getMockHttpServletRequestBuilder(String method, String path, Object param) throws Exception {
        MockHttpServletRequestBuilder requestBuilder;
        switch (method) {
            case "get":
                requestBuilder = get(path);
                break;
            case "post":
                requestBuilder = post(path);
                break;
            default:
                throw new Exception("不支持的请求方法");
        }
        return requestBuilder.contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(param));
    }
}
