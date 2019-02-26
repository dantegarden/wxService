package com.bjdvt.wx.model;

import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-07-11
 */
public class PurchaseOrderReplayLine {
    private Integer id;

    private Date createTime;

    private String replay;

    private Short price;

    private String remark;

    private Short amount;

    private Integer purchaseOrderLineId;

    private Integer saleOrderReplyCopy1Id;

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

    public Short getPrice() {
        return price;
    }

    public void setPrice(Short price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Short getAmount() {
        return amount;
    }

    public void setAmount(Short amount) {
        this.amount = amount;
    }

    public Integer getPurchaseOrderLineId() {
        return purchaseOrderLineId;
    }

    public void setPurchaseOrderLineId(Integer purchaseOrderLineId) {
        this.purchaseOrderLineId = purchaseOrderLineId;
    }

    public Integer getSaleOrderReplyCopy1Id() {
        return saleOrderReplyCopy1Id;
    }

    public void setSaleOrderReplyCopy1Id(Integer saleOrderReplyCopy1Id) {
        this.saleOrderReplyCopy1Id = saleOrderReplyCopy1Id;
    }
}