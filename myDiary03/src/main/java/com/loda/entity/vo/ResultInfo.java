package com.loda.entity.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author loda
 * @Date 2022/11/4 17:13
 * @Description 消息实体类
 * @Version 1.0
 */
@Getter
@Setter
public class ResultInfo<T> {
    private Integer statusCode;
    private String msg;
    private T rsObj;
}
