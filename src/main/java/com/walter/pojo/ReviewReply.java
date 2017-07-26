package com.walter.pojo;


import java.util.Date;

/**
 * Created by walter on 2017/7/23.
 * 回复评论
 */
public class ReviewReply {
    private int rId;
    private Review review;
    private String rReypy;
    private Date createTime;
    private Date updateTime;

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public String getrReypy() {
        return rReypy;
    }

    public void setrReypy(String rReypy) {
        this.rReypy = rReypy;
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
        return "ReviewReply{" +
                "rId=" + rId +
                ", review=" + review +
                ", rReypy='" + rReypy + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
