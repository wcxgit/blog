package com.walter.pojo;


import java.util.Date;

/**
 * Created by walter on 2017/7/23.
 * 留言回复表
 */
public class MessageReply {
    private int mrId;
    private Message message;
    private String mrContent;//回复的留言的内容
    private int mrParentId;//是否对回复还有回复内容?-1:没有对回复的内容进行回复;其他:回复的id mr_id
    private String mrContentReply;//对回复的回复内容
    private Date createTime;
    private Date updateTime;

    public int getMrId() {
        return mrId;
    }

    public void setMrId(int mrId) {
        this.mrId = mrId;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getMrContent() {
        return mrContent;
    }

    public void setMrContent(String mrContent) {
        this.mrContent = mrContent;
    }

    public int getMrParentId() {
        return mrParentId;
    }

    public void setMrParentId(int mrParentId) {
        this.mrParentId = mrParentId;
    }

    public String getMrContentReply() {
        return mrContentReply;
    }

    public void setMrContentReply(String mrContentReply) {
        this.mrContentReply = mrContentReply;
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
        return "MessageReply{" +
                "mrId=" + mrId +
                ", message=" + message +
                ", mrContent='" + mrContent + '\'' +
                ", mrParentId=" + mrParentId +
                ", mrContentReply='" + mrContentReply + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
