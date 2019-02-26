package com.bjdvt.wx.util;

public class ResultMsg {
	// 成员变量  
    private String errorMsg;  
    private int errorCode;  
    private AccessToken token;
    
    public ResultMsg(int errorCode,String errorMsg,AccessToken accessTokenEntity) {
    	this.errorCode=errorCode;
    	this.errorMsg=errorMsg;
    	this.token=accessTokenEntity;
    }
    
    public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public AccessToken getToken() {
		return token;
	}

	public void setToken(AccessToken token) {
		this.token = token;
	}

	public String toString() {
		return "errorCode:"+this.errorCode+" errorMsg:"+this.errorMsg;
    	
    }
}
