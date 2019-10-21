package com.example.cn.demoapplication.common;

import lombok.Data;

/**
 * @program: demoapplication
 * @author: 大企业业务部 huyaou
 * @date: 2019年10月21日 08:40
 * @description: 分页返回体
 */
@Data
public class PageResultBean extends ResultBean {
    private Integer pageNo;

    private Integer pageSize;

    private Integer totalPages;

}
