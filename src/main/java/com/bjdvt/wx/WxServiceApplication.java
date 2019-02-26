package com.bjdvt.wx;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bjdvt.wx.exception.CustomException;
import com.bjdvt.wx.filter.HTTPBearerAuthorizeAttribute;
@MapperScan("com.bjdvt.wx.mapper.**")
@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
@EnableAutoConfiguration(exclude = { JacksonAutoConfiguration.class })
public class WxServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WxServiceApplication.class, args);
	}

	
	
	/*
	@Bean
	public FilterRegistrationBean jwtFilterRegistrationBean(){
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		HTTPBearerAuthorizeAttribute httpBearerFilter = new HTTPBearerAuthorizeAttribute();
		registrationBean.setFilter(httpBearerFilter);
		List<String> urlPatterns = new ArrayList<String>();
	    urlPatterns.add("/");
	    registrationBean.setUrlPatterns(urlPatterns);
	    return registrationBean;
	}
	
	@Bean(name = "sessionFilter")
	public HTTPBearerAuthorizeAttribute sessionFilter() {
	  return new HTTPBearerAuthorizeAttribute();
	}*/
}
