package com.bjdvt.wx.model;

import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-07-11
 */
public class PurchaseOrder {
    private Integer id;

    private Date createTime;

    private Integer wxUserId;

    private Integer wxCompanyId;

    private String code;

    private String version;

    private String remark;

    private String paydescribe;

    private String paytype;

    private Integer invoicetype;

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

    public Integer getWxCompanyId() {
        return wxCompanyId;
    }

    public void setWxCompanyId(Integer wxCompanyId) {
        this.wxCompanyId = wxCompanyId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPaydescribe() {
        return paydescribe;
    }

    public void setPaydescribe(String paydescribe) {
        this.paydescribe = paydescribe == null ? null : paydescribe.trim();
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
    }

    public Integer getInvoicetype() {
        return invoicetype;
    }

    public void setInvoicetype(Integer invoicetype) {
        this.invoicetype = invoicetype;
    }
}