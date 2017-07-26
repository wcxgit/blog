package com.walter.pojo;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.Date;

/**
 * Created by walter on 2017/7/24.
 * 导航
 */
public class NavBar {
    private int nId;
    private String nName;
    private String nPath;
    private Date createTime;
    private Date updateTime;

    public int getnId() {
        return nId;
    }

    public void setnId(int nId) {
        this.nId = nId;
    }

    public String getnName() {
        return nName;
    }

    public void setnName(String nName) {
        this.nName = nName;
    }

    public String getnPath() {
        return nPath;
    }

    public void setnPath(String nPath) {
        this.nPath = nPath;
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
        return "NavBar{" +
                "nId=" + nId +
                ", nName='" + nName + '\'' +
                ", nPath='" + nPath + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(new Date().getTime());
    }
}
