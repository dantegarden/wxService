package com.bjdvt.wx.model;

import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-07-11
 */
public class SaleOrder {
    private Integer id;

    private String name;

    private Date createTime;

    private String describe;

    private Integer paytyle;

    private String paydescribe;

    private Integer invoicetype;

    private String version;

    private Integer wxUserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public Integer getPaytyle() {
        return paytyle;
    }

    public void setPaytyle(Integer paytyle) {
        this.paytyle = paytyle;
    }

    public String getPaydescribe() {
        return paydescribe;
    }

    public void setPaydescribe(String paydescribe) {
        this.paydescribe = paydescribe == null ? null : paydescribe.trim();
    }

    public Integer getInvoicetype() {
        return invoicetype;
    }

    public void setInvoicetype(Integer invoicetype) {
        this.invoicetype = invoicetype;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public Integer getWxUserId() {
        return wxUserId;
    }

    public void setWxUserId(Integer wxUserId) {
        this.wxUserId = wxUserId;
    }
}