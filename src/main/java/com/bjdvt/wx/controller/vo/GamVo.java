package com.bjdvt.wx.controller.vo;

public class GamVo {

	private	Integer ownerId;
	private	Integer userId;
	private	Integer productId;
	private	boolean isNew;
	private	String lastShareId;
	
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public boolean isNew() {
		return isNew;
	}
	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
	public String getLastShareId() {
		return lastShareId;
	}
	public void setLastShareId(String lastShareId) {
		this.lastShareId = lastShareId;
	}
	
	
	
}
