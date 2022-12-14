package com.loda.query;

import com.loda.base.BaseQuery;

/**
 * @Author loda
 * @Date 2022/12/6 18:34
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class LoginInfoQuery extends BaseQuery {

    private String tLoginTime;

    public String gettLoginTime() {
        return tLoginTime;
    }

    public void settLoginTime(String tLoginTime) {
        this.tLoginTime = tLoginTime;
    }
}
