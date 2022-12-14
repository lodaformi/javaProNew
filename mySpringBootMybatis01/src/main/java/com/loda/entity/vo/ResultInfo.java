package com.loda.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author loda
 * @Date 2022/11/19 17:54
 * @Description 消息模型
 * @Version 1.0
 */
@ApiModel(description = "消息模型")
public class ResultInfo<T> {
    @ApiModelProperty(value = "状态码")
    private Integer code=200;
    @ApiModelProperty(value = "提示消息")
    private String msg="操作成功";
    @ApiModelProperty(value = "返回对象")
    private T obj;


    public ResultInfo() {
    }

    public ResultInfo(Integer code, String msg, T obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }

    /**
     * 获取
     * @return code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 获取
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取
     * @return obj
     */
    public T getObj() {
        return obj;
    }

    /**
     * 设置
     * @param obj
     */
    public void setObj(T obj) {
        this.obj = obj;
    }

    public String toString() {
        return "ResultInfo{code = " + code + ", msg = " + msg + ", obj = " + obj + "}";
    }
}
