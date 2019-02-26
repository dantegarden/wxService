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
public class ProductDescribe {
    private Integer id;

    private Integer productId;

    private String title;

    private String text;

    private Date createTime;

    private Integer wxUserId;

    private Integer companyId;
    
    private String key;

    private List<ProductDescribeImages> productDescribeListImages;
    
    
    
   

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<ProductDescribeImages> getProductDescribeListImages() {
		return productDescribeListImages;
	}

	public void setProductDescribeListImages(List<ProductDescribeImages> productDescribeListImages) {
		this.productDescribeListImages = productDescribeListImages;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getWxUserId() {
        return wxUserId;
    }

    public void setWxUserId(Integer wxUserId) {
        this.wxUserId = wxUserId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}