package com.bjdvt.wx.controller.vo;

public class MyContract {

	private	Integer userId;
	private	Integer contractId;
	private	Integer type; //1同事 2 联系人 
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getContractId() {
		return contractId;
	}
	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	
	
	
}
