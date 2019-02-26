package com.bjdvt.wx.model;

import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-08-31
 */
public class MySkim {
    private Integer id;

    private Date createTime;

    private Integer wxUserId;

    private Integer skimUserId;

    private Integer flag;

    private Integer productId;

    private String lastShareId;

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

    public Integer getSkimUserId() {
        return skimUserId;
    }

    public void setSkimUserId(Integer skimUserId) {
        this.skimUserId = skimUserId;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getLastShareId() {
        return lastShareId;
    }

    public void setLastShareId(String lastShareId) {
        this.lastShareId = lastShareId == null ? null : lastShareId.trim();
    }
}