package com.loda.entity.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author loda
 * @Date 2022/11/13 23:27
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
@Getter
@Setter
public class ResultInfo<T> {
    private Integer code;
    private String msg;
    private T rsObj;
}
