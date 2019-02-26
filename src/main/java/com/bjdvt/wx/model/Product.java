package com.bjdvt.wx.model;

import java.util.Date;
import java.util.List;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-07-30
 */
public class Product {
    private Integer id;
    private	Integer productId;
    private String productName;

    private Integer companyId;

    private Date createTime;

    private Short currentPrice;

    private Short originalPrice;

    private String advertising;
    private Integer poster;

    private Integer wxUserId;
    private Integer status;

    private Integer ordernum;
    private	List<ProductImage> productImageList;
    private	List<ProductDescribe> productDescribeList;
    

    
    
    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	

	public Integer getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public Integer getPoster() {
		return poster;
	}

	public void setPoster(Integer poster) {
		this.poster = poster;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public List<ProductImage> getProductImageList() {
		return productImageList;
	}

	public void setProductImageList(List<ProductImage> productImageList) {
		this.productImageList = productImageList;
	}

	public List<ProductDescribe> getProductDescribeList() {
		return productDescribeList;
	}

	public void setProductDescribeList(List<ProductDescribe> productDescribeList) {
		this.productDescribeList = productDescribeList;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Short currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Short getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Short originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getAdvertising() {
        return advertising;
    }

    public void setAdvertising(String advertising) {
        this.advertising = advertising == null ? null : advertising.trim();
    }

    public Integer getWxUserId() {
        return wxUserId;
    }

    public void setWxUserId(Integer wxUserId) {
        this.wxUserId = wxUserId;
    }
}