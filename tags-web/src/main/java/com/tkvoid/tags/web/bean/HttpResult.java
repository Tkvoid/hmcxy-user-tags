package com.tkvoid.tags.web.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HttpResult<T> {
    private Integer code; //000成功 999失败
    private String msg; // 给用户的提示信息
    private T data; // 响应的集合数据

}
