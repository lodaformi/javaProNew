package com.loda.entity.vo;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author loda
 * @Date 2022/12/6 16:28
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class UserFromInfo {
    private Integer id;
    private String username;
    private String ip;
    private String date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
}
