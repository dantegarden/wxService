package com.bjdvt.wx.serviceImp;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.bjdvt.wx.controller.vo.TokenResult;

@Component
@CacheConfig
public class TokenRepository  implements TokenService{
	@Value("${appid}")
	private final String appid = "wxc86f79eeb8fdb588";
	@Value("${secret")
	private final String secret = "e342678231774050626e7991c88e1012";
	@Autowired
	private HttpServiceImp httpServiceImp;
	
	Logger logger = LoggerFactory.getLogger(WxUserServiceImp.class);
	
	@Cacheable(value={"token"}, key="#id")
    public TokenResult getToken(String id) {
		  return getAccess_token();
    }
	
	@CachePut(value={"token"}, key="#id")
    public TokenResult getNewToken(String id) {
        return getAccess_token();
    }
	public TokenResult getAccess_token() {
		logger.info("getAccess_token开始");
		String url = "https://api.weixin.qq.com/cgi-bin/token";
		Map<String, Object> paramsMap = new HashMap();
		paramsMap.put("grant_type", "client_credential");
		paramsMap.put("appid", appid);
		paramsMap.put("secret",secret);
		String result=httpServiceImp.get(url, paramsMap);
		logger.info(result);
		TokenResult tokenResult = JSON.parseObject(result,TokenResult.class);
		Long time=new Date().getTime()+tokenResult.getExpires_in()-2000;
		tokenResult.setTimeout(new Date(time));
		return tokenResult;
	}

}
