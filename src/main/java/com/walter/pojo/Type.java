package com.walter.pojo;


import java.util.Date;

/**
 * Created by walter on 2017/7/23.
 * 博客类别
 */
public class Type {
    private int tId;
    private String tName;
    private UserInfo userInfo;
    private Date createTime;
    private Date updateTime;

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Type{" +
                "tId=" + tId +
                ", tName='" + tName + '\'' +
                ", userInfo=" + userInfo +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
