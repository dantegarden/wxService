package com.bjdvt.wx.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.bjdvt.wx.util.AudienceEntity;
import com.bjdvt.wx.util.GrantedAuthorityImpl;
import com.bjdvt.wx.util.JwtHelper;
import com.bjdvt.wx.util.ResultMsg;
import com.bjdvt.wx.util.ResultStatusCode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;




public class HTTPBearerAuthorizeAttribute  extends BasicAuthenticationFilter{
	
	private static final Logger logger = LoggerFactory.getLogger(HTTPBearerAuthorizeAttribute.class);

    public HTTPBearerAuthorizeAttribute(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }
   
	 @Override
	 protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
	     logger.info("begin filter");
	    String header = request.getHeader("Authorization");
	    logger.info("header="+header);
	    if (header == null || !header.startsWith("bearer")) {
	            chain.doFilter(request, response);
	            return;
	    }
	   
		String auth = request.getHeader("Authorization");
		if ((auth != null) && (auth.length() > 7))
		{
			
			String HeadStr = auth.substring(0, 6).toLowerCase();
			if (HeadStr.compareTo("bearer") == 0)
			{
				AudienceEntity audienceEntity=new AudienceEntity();
				auth = auth.substring(7, auth.length()); 
				logger.info("auth="+auth);
				Claims claims=JwtHelper.parseJWT(auth, audienceEntity.getBase64Secret());
				if(claims==null) {
					 chain.doFilter(request, response);
			            return;
				}
				String userId=(String)claims.get("userid");
				 List<String> roleList=(List)claims.get("auth");
				 ArrayList<GrantedAuthority> authorities = new ArrayList<>();
	             for (int i=0; i < roleList.size(); i++) {
	                    authorities.add(new GrantedAuthorityImpl(roleList.get(i)));
	             }
	             UsernamePasswordAuthenticationToken userToken=new UsernamePasswordAuthenticationToken(userId, null, authorities);
	             SecurityContextHolder.getContext().setAuthentication(userToken);
	              chain.doFilter(request, response);
	              return;
	           
			}
		
			
		}
		
		
		return;
	}
 
}
