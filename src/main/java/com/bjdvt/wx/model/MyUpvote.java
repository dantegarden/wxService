package com.bjdvt.wx.model;

import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-07-30
 */
public class MyUpvote {
    private Integer id;

    private Date createTime;

    private Integer wxUserId;

    private Integer upvoteUserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getWxUserId() {
        return wxUserId;
    }

    public void setWxUserId(Integer wxUserId) {
        this.wxUserId = wxUserId;
    }

    public Integer getUpvoteUserId() {
        return upvoteUserId;
    }

    public void setUpvoteUserId(Integer upvoteUserId) {
        this.upvoteUserId = upvoteUserId;
    }
}