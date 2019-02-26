package com.bjdvt.wx.model;

import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-07-11
 */
public class SaleOrderReplayLine {
    private Integer id;

    private Date createTime;

    private String replay;

    private Integer saleOrderLineId;

    private Integer saleOrderReplyId;

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

    public String getReplay() {
        return replay;
    }

    public void setReplay(String replay) {
        this.replay = replay == null ? null : replay.trim();
    }

    public Integer getSaleOrderLineId() {
        return saleOrderLineId;
    }

    public void setSaleOrderLineId(Integer saleOrderLineId) {
        this.saleOrderLineId = saleOrderLineId;
    }

    public Integer getSaleOrderReplyId() {
        return saleOrderReplyId;
    }

    public void setSaleOrderReplyId(Integer saleOrderReplyId) {
        this.saleOrderReplyId = saleOrderReplyId;
    }
}