package com.loda.exceptions;

/**
 * @Author loda
 * @Date 2022/11/19 17:12
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class ParamsException extends Exception{
    private Integer code=300;
    private String msg="参数异常!";

    public ParamsException() {
        super("参数异常");
    }
    public ParamsException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public ParamsException(Integer code) {
        super("参数异常!");
        this.code = code;
    }

    public ParamsException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
