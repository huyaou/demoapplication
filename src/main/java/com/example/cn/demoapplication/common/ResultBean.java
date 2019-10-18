package com.example.cn.demoapplication.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.example.cn.demoapplication.common.exception.BaseException;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: demoapplication
 * @author: 大企业业务部 huyaou
 * @date: 2019年10月18日 13:51
 * @description: 统一返回实体格式，controller专用，不允许向service传
 */
@Data
public class ResultBean<T> implements Serializable {

    private static final Long serialVerioUID = 1L;

    @JSONField
    private  Boolean success = true;
    @JSONField
    private String message = null;
    @JSONField
    private String errorMsg = null;
    @JSONField
    private String errorCode = "0";
    @JSONField
    private List<T> data = new ArrayList<>();
    @JSONField
    private Integer total = 0;

    public ResultBean (){}

    public ResultBean (T data) {
        this.data.add(data);
    }

    public ResultBean (List data) {
        if (data != null && !data.isEmpty()) {
            this.data = data;
            this.total = data.size();
        }
    }

    public ResultBean (BaseException e) {
        if (e != null) {
            this.errorMsg = e.getErrorMsg();
            this.errorCode = e.getErrorCode();
            this.success = false;
        }
    }

}
