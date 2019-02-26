package com.bjdvt.wx.controller.vo;

import java.util.List;

import com.bjdvt.wx.model.IntroductionImages;

public class UserVo {

	public	Integer userId;
	public	String companyId;
	
	public	 String avatar;
	public  String loginName;
	public 	String weixin;
	public	String company;
	public	String job;
	public	String companyAddress;
	public	 String companyEmail;
	public	String signature;
	public	String phone;
	public	String introductionImg;
	public  String signatureTitle;
	public String introductionTitle;
	public List<IntroductionImages> introduction;
	
	
	public String getSignatureTitle() {
		return signatureTitle;
	}
	public void setSignatureTitle(String signatureTitle) {
		this.signatureTitle = signatureTitle;
	}
	public String getIntroductionTitle() {
		return introductionTitle;
	}
	public void setIntroductionTitle(String introductionTitle) {
		this.introductionTitle = introductionTitle;
	}
	public List<IntroductionImages> getIntroduction() {
		return introduction;
	}
	public void setIntroduction(List<IntroductionImages> introduction) {
		this.introduction = introduction;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIntroductionImg() {
		return introductionImg;
	}
	public void setIntroductionImg(String introductionImg) {
		this.introductionImg = introductionImg;
	}
	
	
}
