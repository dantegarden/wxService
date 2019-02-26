package com.bjdvt.wx.controller.vo;

import com.bjdvt.wx.model.WxMessage;

public class WxMessageVo {
	private WxMessage message;
	private String formId;
	public WxMessage getMessage() {
		return message;
	}
	public void setMessage(WxMessage message) {
		this.message = message;
	}
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	
}
