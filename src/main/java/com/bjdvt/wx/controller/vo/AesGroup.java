package com.bjdvt.wx.controller.vo;

public class AesGroup {
	private	String   encryptedData; //加密数据串
	private String   iv ; //加密向量
	private	String   session_key; //用来aes解密的因子
	public String getEncryptedData() {
		return encryptedData;
	}
	public void setEncryptedData(String encryptedData) {
		this.encryptedData = encryptedData;
	}
	public String getIv() {
		return iv;
	}
	public void setIv(String iv) {
		this.iv = iv;
	}
	public String getSession_key() {
		return session_key;
	}
	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}
	
	
}
