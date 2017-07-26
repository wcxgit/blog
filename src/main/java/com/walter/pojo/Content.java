package com.walter.pojo;


import java.util.Date;

/**
 * Created by walter on 2017/7/23.
 * 博客内容
 */
public class Content {
    private int cId;
    private UserInfo userInfo;
    private Type type;
    private String cContent;//博客内容
    private int cViewCount;//博客被查看总数
    private int cReviewCount;//博客被回复的总数
    private String cTitle;
    private String cAbstract;
    private Date createTime;
    private Date updateTime;

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent;
    }

    public int getcViewCount() {
        return cViewCount;
    }

    public void setcViewCount(int cViewCount) {
        this.cViewCount = cViewCount;
    }

    public int getcReviewCount() {
        return cReviewCount;
    }

    public void setcReviewCount(int cReviewCount) {
        this.cReviewCount = cReviewCount;
    }

    public String getcTitle() {
        return cTitle;
    }

    public void setcTitle(String cTitle) {
        this.cTitle = cTitle;
    }

    public String getcAbstract() {
        return cAbstract;
    }

    public void setcAbstract(String cAbstract) {
        this.cAbstract = cAbstract;
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
        return "Content{" +
                "cId=" + cId +
                ", userInfo=" + userInfo +
                ", type=" + type +
                ", cContent='" + cContent + '\'' +
                ", cViewCount=" + cViewCount +
                ", cReviewCount=" + cReviewCount +
                ", cTitle='" + cTitle + '\'' +
                ", cAbstract='" + cAbstract + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
