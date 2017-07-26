package com.walter.pojo;

import java.util.Date;

/**
 * Created by walter on 2017/7/23.
 * 评论
 */
public class Review {
    private int r_id;
    private Content content;
    private String rContent;//评论的内容
    private int cCount ;//评论数
    private Date createTime;
    private Date updateTime;

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getrContent() {
        return rContent;
    }

    public void setrContent(String rContent) {
        this.rContent = rContent;
    }

    public int getcCount() {
        return cCount;
    }

    public void setcCount(int cCount) {
        this.cCount = cCount;
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
        return "Review{" +
                "r_id=" + r_id +
                ", content=" + content +
                ", rContent='" + rContent + '\'' +
                ", cCount=" + cCount +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
