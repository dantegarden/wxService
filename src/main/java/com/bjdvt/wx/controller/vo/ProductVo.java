package com.bjdvt.wx.controller.vo;

public class ProductVo {

	private	 Integer productId;
	private Integer companyId;
	
	private	Double currentPrice;
	private	Double originalPrice;
	private	String productName;
	private	String advertising;
	private Integer poster;
	private	Integer status;
	private	Integer orderNum;
	
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public Double getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getAdvertising() {
		return advertising;
	}
	public void setAdvertising(String advertising) {
		this.advertising = advertising;
	}
	public Integer getPoster() {
		return poster;
	}
	public void setPoster(Integer poster) {
		this.poster = poster;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	
	
	  
}
