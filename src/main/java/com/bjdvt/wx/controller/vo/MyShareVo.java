package com.bjdvt.wx.controller.vo;

public class MyShareVo {
	private String lastShareId ;    //上个shareId 不一定有
	private	Integer lastFromUserId ; //上个转发者  不一定有
	private String shareId ; //当前的shareId
	private	Integer ownerId ; //转发内容的所有者
	private	Integer ownerCompanyId; //转发内容的所有者的公司
	private	Integer fromUserId; //当前的转发人
	private AesGroup aesGroup;  //只有在转发到群时才存在
	private	Integer productId;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getLastShareId() {
		return lastShareId;
	}
	public void setLastShareId(String lastShareId) {
		this.lastShareId = lastShareId;
	}
	
	public Integer getLastFromUserId() {
		return lastFromUserId;
	}
	public void setLastFromUserId(Integer lastFromUserId) {
		this.lastFromUserId = lastFromUserId;
	}
	public String getShareId() {
		return shareId;
	}
	public void setShareId(String shareId) {
		this.shareId = shareId;
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
	public AesGroup getAesGroup() {
		return aesGroup;
	}
	public void setAesGroup(AesGroup aesGroup) {
		this.aesGroup = aesGroup;
	}
	
	


}
