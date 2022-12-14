package com.loda.query;

/**
 * @Author loda
 * @Date 2022/11/19 17:02
 * @Description TODO(一句话描述该类的功能)
 * @Version 1.0
 */
public class UserQuery {
    private Integer pageNum=1;
    private Integer pageSize=10;
    private String userName;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
