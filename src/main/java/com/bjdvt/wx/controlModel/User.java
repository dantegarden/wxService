package com.bjdvt.wx.controlModel;

import java.util.List;

import com.bjdvt.wx.model.IntroductionImages;

public class User {
	//{"userId":10,"companyId":"","avatar":71,"loginName":"李倞","phone":"15810314766","company":"北京迪威特科技有限公司","job":"研发工程师","companyAddress":"北京市海淀区长春桥路17号","companyEmail":"761043617@qq.com","signature":"呵呵呵","introductionImg":72}
	public	Integer userId;
	public	Integer companyId;
	
	public	 Integer avatar;
	public  String loginName;
	public 	String weixin;
	public	String company;
	public	String job;
	public	String companyAddress;
	public	 String companyEmail;
	public	String signature;
	public	String phone;
	public	Integer introductionImg;
	public  Integer contacttype;  //0本人 1同事 2 客户
	public Integer role;
	public  String signatureTitle;
	public String introductionTitle;
	public List<IntroductionImages> introduction;
	
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public Integer getContacttype() {
		return contacttype;
	}
	public void setContacttype(Integer contacttype) {
		this.contacttype = contacttype;
	}
	public Integer getAvatar() {
		return avatar;
	}
	public void setAvatar(Integer avatar) {
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
	
	public Integer getIntroductionImg() {
		return introductionImg;
	}
	public void setIntroductionImg(Integer introductionImg) {
		this.introductionImg = introductionImg;
	}

	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
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
	
	
	
	
}
