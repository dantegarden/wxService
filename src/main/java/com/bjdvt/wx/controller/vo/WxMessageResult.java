package com.bjdvt.wx.controller.vo;

import java.util.Date;

public class WxMessageResult {

	 private Integer id;

	    private String loginName;

	    private long sendTime;

	    private String words;

	    private Integer status;

	    private Integer fromUserId;

	    private Integer toUserId;

	    private String phone;

	    private String company;
	    
	    private	Integer fromUserAvatar;
	    private	Integer fromUserCompanyId;
	    
	    private	Integer toUserAvatar;
	    private	String toUserCompany;
	    private	Integer toUserCompanyId;
	    private	String toUserName;
	    private String  toUserPhone;
	    

		


		public String getToUserPhone() {
			return toUserPhone;
		}

		public void setToUserPhone(String toUserPhone) {
			this.toUserPhone = toUserPhone;
		}

		public Integer getToUserAvatar() {
			return toUserAvatar;
		}

		public void setToUserAvatar(Integer toUserAvatar) {
			this.toUserAvatar = toUserAvatar;
		}

		

		

		public String getToUserCompany() {
			return toUserCompany;
		}

		public void setToUserCompany(String toUserCompany) {
			this.toUserCompany = toUserCompany;
		}

		public Integer getToUserCompanyId() {
			return toUserCompanyId;
		}

		public void setToUserCompanyId(Integer toUserCompanyId) {
			this.toUserCompanyId = toUserCompanyId;
		}

		public String getToUserName() {
			return toUserName;
		}

		public void setToUserName(String toUserName) {
			this.toUserName = toUserName;
		}

		public Integer getFromUserAvatar() {
			return fromUserAvatar;
		}

		public void setFromUserAvatar(Integer fromUserAvatar) {
			this.fromUserAvatar = fromUserAvatar;
		}

		

		public Integer getFromUserCompanyId() {
			return fromUserCompanyId;
		}

		public void setFromUserCompanyId(Integer fromUserCompanyId) {
			this.fromUserCompanyId = fromUserCompanyId;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getLoginName() {
			return loginName;
		}

		public void setLoginName(String loginName) {
			this.loginName = loginName;
		}

		public long getSendTime() {
			return sendTime;
		}

		public void setSendTime(long sendTime) {
			this.sendTime = sendTime;
		}

		public String getWords() {
			return words;
		}

		public void setWords(String words) {
			this.words = words;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public Integer getFromUserId() {
			return fromUserId;
		}

		public void setFromUserId(Integer fromUserId) {
			this.fromUserId = fromUserId;
		}

		public Integer getToUserId() {
			return toUserId;
		}

		public void setToUserId(Integer toUserId) {
			this.toUserId = toUserId;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}
	    
	    
}
