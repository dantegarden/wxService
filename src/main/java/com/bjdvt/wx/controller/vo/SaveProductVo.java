package com.bjdvt.wx.controller.vo;

import com.bjdvt.wx.IntegerDefault0Adapter;
import com.bjdvt.wx.model.Product;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = IntegerDefault0Adapter.class)
public class SaveProductVo {
  private	Integer userId;
  private    Product product;
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
 
  
}
