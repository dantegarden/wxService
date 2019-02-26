package com.bjdvt.wx.util;

public enum ResultStatusCode {  
	OK( "Ok",0),
	SYSTEM_ERR( "system error",30000),
	INVALID_CLIENTID( "Invalid clientid",30003),
	INVALID_PASSWORD( "User name or password is incorrect",30004),
	INVALID_CAPTCHA( "Invalid captcha or captcha overdue",30005),
	INVALID_TOKEN( "Invalid token",30006);  
    // 成员变量  
    private String errorMsg;  
    private int errorCode;  
    // 构造方法  
    private ResultStatusCode(String errorMsg, int errorCode) {  
        this.errorMsg = errorMsg;  
        this.errorCode = errorCode;  
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

	//覆盖方法  
    @Override  
    public String toString() {  
        return this.errorCode+"_"+this.errorMsg;  
    }  
}  