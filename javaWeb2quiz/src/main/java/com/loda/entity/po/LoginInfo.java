package com.loda.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

public class LoginInfo {
    private Integer id;

    private Integer userId;

    private String username;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")     //参数是时间类型，字符串传入的格式
    private LocalDateTime tLoginTime;

    private String tLoginIp;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime gettLoginTime() {
        return tLoginTime;
    }

    public void settLoginTime(LocalDateTime tLoginTime) {
        this.tLoginTime = tLoginTime;
    }

    public String gettLoginIp() {
        return tLoginIp;
    }

    public void settLoginIp(String tLoginIp) {
        this.tLoginIp = tLoginIp == null ? null : tLoginIp.trim();
    }
}