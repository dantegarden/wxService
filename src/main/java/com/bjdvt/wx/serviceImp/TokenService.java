package com.bjdvt.wx.serviceImp;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import com.bjdvt.wx.controller.vo.TokenResult;

public interface TokenService {

	
    public TokenResult getToken(String id) ;
	
    public TokenResult getNewToken(String id);
	
}
