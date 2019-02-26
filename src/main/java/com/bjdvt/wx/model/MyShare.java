package com.bjdvt.wx.model;

import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-08-23
 */
public class MyShare {
    private Integer id;

    private Date createTime;

    private String lastShareId;

    private Integer lastFormUserId;

    private String shareId;

    private Integer ownerId;

    private Integer ownerCompanyId;

    private Integer fromUserId;

    private String groupId;

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

    public String getLastShareId() {
        return lastShareId;
    }

    public void setLastShareId(String lastShareId) {
        this.lastShareId = lastShareId == null ? null : lastShareId.trim();
    }

    public Integer getLastFormUserId() {
        return lastFormUserId;
    }

    public void setLastFormUserId(Integer lastFormUserId) {
        this.lastFormUserId = lastFormUserId;
    }

    public String getShareId() {
        return shareId;
    }

    public void setShareId(String shareId) {
        this.shareId = shareId == null ? null : shareId.trim();
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getOwnerCompanyId() {
        return ownerCompanyId;
    }

    public void setOwnerCompanyId(Integer ownerCompanyId) {
        this.ownerCompanyId = ownerCompanyId;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }
}