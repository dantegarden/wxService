package com.bjdvt.wx.model;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-07-12
 */
public class WxMyuser {
    private Integer id;

    private Integer type;

    private Integer wxUserId;
    private	Integer myUserId;
    

    public Integer getMyUserId() {
		return myUserId;
	}

	public void setMyUserId(Integer myUserId) {
		this.myUserId = myUserId;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getWxUserId() {
        return wxUserId;
    }

    public void setWxUserId(Integer wxUserId) {
        this.wxUserId = wxUserId;
    }
}