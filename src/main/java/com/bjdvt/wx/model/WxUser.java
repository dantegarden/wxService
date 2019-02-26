package com.bjdvt.wx.model;

import java.util.Date;
import java.util.List;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-09-17
 */
public class WxUser {
    private Integer id;

    private String name;

    private Integer createId;

    private Date createTime;

    private String wxId;

    private Integer avatar;

    private String phone;

    private String email;

    private String address;

    private String signature;

    private Integer wxCompanyId;

    private String job;

    private Integer introductionimg;

    private Integer role;

    private String signatureTitle;

    private String introductionTitle;
    
    public List<IntroductionImages> introduction;
    

    public List<IntroductionImages> getIntroduction() {
		return introduction;
	}

	public void setIntroduction(List<IntroductionImages> introduction) {
		this.introduction = introduction;
	}

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

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId == null ? null : wxId.trim();
    }

    public Integer getAvatar() {
        return avatar;
    }

    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    public Integer getWxCompanyId() {
        return wxCompanyId;
    }

    public void setWxCompanyId(Integer wxCompanyId) {
        this.wxCompanyId = wxCompanyId;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public Integer getIntroductionimg() {
        return introductionimg;
    }

    public void setIntroductionimg(Integer introductionimg) {
        this.introductionimg = introductionimg;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getSignatureTitle() {
        return signatureTitle;
    }

    public void setSignatureTitle(String signatureTitle) {
        this.signatureTitle = signatureTitle == null ? null : signatureTitle.trim();
    }

    public String getIntroductionTitle() {
        return introductionTitle;
    }

    public void setIntroductionTitle(String introductionTitle) {
        this.introductionTitle = introductionTitle == null ? null : introductionTitle.trim();
    }
}