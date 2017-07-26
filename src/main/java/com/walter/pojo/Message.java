package com.walter.pojo;


import java.util.Date;

/**
 * Created by walter on 2017/7/23.
 * 留言板
 */
public class Message {
    private int mId;
    private UserInfo userInfo;
    private String mContent;//留言内容
    private Date createTime;
    private Date updateTime;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
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
        return "Message{" +
                "mId=" + mId +
                ", userInfo=" + userInfo +
                ", mContent='" + mContent + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
