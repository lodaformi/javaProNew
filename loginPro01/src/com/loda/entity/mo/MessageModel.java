package com.loda.entity.mo;

/**
 * @Author loda
 * @Date 2022/11/3 16:56
 * @Description 消息模型类
 * @Version 1.0
 */
public class MessageModel {
    private Integer status;
    private String msg;
    private Object object;

    public MessageModel() {
    }

    public MessageModel(Integer status, String msg, Object object) {
        this.status = status;
        this.msg = msg;
        this.object = object;
    }

    /**
     * 获取
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
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
     * @return object
     */
    public Object getObject() {
        return object;
    }

    /**
     * 设置
     * @param object
     */
    public void setObject(Object object) {
        this.object = object;
    }

    public String toString() {
        return "MessageModel{status = " + status + ", msg = " + msg + ", object = " + object + "}";
    }
}
