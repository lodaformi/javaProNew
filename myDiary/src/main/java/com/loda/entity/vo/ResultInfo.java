package com.loda.entity.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author loda
 * @Date 2022/11/4 17:13
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Getter
@Setter
public class ResultInfo<T> {
    private Integer statusCode;
    private String msg;
    private T rsObj;
}
