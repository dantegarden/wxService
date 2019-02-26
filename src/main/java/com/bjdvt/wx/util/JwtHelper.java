package com.bjdvt.wx.util;
import java.security.Key;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.FilterChain;
import javax.xml.bind.DatatypeConverter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
 
public class JwtHelper {
	public static Claims parseJWT(String jsonWebToken, String base64Security){
		try
		{
			Claims claims = Jwts.parser()
					   .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
					   .parseClaimsJws(jsonWebToken).getBody();
			return claims;
		}
		catch(Exception ex)
		{
			return null;
		}
	}
	
	public static String createJWT( String userId, 
			String audience, String issuer, long TTLMillis, String base64Security,ArrayList<GrantedAuthority> authoritieList) 
	{
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		 
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		 
		//生成签名密钥
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Security);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		// 定义存放角色集合的对象
        List roleList = new ArrayList<>();
        for (GrantedAuthority grantedAuthority : authoritieList) {
            roleList.add(grantedAuthority.getAuthority());
        }
		  //添加构成JWT的参数
		JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
				                        .claim("userid", userId)
				                        .claim("auth", roleList)
				                        .setIssuer(issuer)
				                        .setAudience(audience)
		                                .signWith(signatureAlgorithm, signingKey);
		 //添加Token过期时间
		if (TTLMillis >= 0) {
		    long expMillis = nowMillis + TTLMillis+60*1000*30;
		    Date exp = new Date(expMillis);
		    builder.setExpiration(exp).setNotBefore(now);
		}
	
		
		 //生成JWT
		return builder.compact();
	}
	
	
}

