package com.bjdvt.wx.util;

import javax.xml.bind.DatatypeConverter;

public class AudienceEntity {

	String secret="abc";
	int expiresSecond=60*60*24*7;
	public String getBase64Secret()
	{
		return DatatypeConverter.printBase64Binary(secret.getBytes());
	}
	public String getClientId() {
		return "wx_id";
	}
	public String getName() {
		return "like";
	}
	public int getExpiresSecond() {
		return expiresSecond;
	}
}
