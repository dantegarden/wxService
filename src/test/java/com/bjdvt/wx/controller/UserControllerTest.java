package com.bjdvt.wx.controller;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.alibaba.fastjson.JSON;
import com.bjdvt.wx.WxServiceApplication;
import com.bjdvt.wx.controlModel.User;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserControllerTest {
	
	private MockMvc mvc;
	 
	@Autowired
	private UserController userController;
	
	@Before
    public void setUp(){
		System.out.println("begin");
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }
	
	
	 
	//@Test
	public void getWxSessionKey() {
		
        try {
        	System.out.println("mvc="+mvc);
			mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/user/getWxSessionKey/001eFyfV01HKoV1ABAfV0POzfV0eFyfI"))
			        .andExpect(MockMvcResultMatchers.status().isOk())
			        .andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 打印结果
		//String result=userController.getWxSessionKey("061eUhuk2ZVxTE0rFEvk2zaguk2eUhu5");
		//System.out.println(result);
	}

	@Test
	public void show() {
		
        try {
        	System.out.println("mvc="+mvc);
        	User user=JSON.parseObject("{userId: \"1\",companyId:\"1\",inctroductionImg:\"1\",avatar: \"1\", loginName:\"1\" }",User.class);
        	String str=JSON.toJSONString(user);
        	String data="{userid:1,companyId:1}";
        	System.out.println(data);
			mvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/user/save")
					.contentType(MediaType.APPLICATION_JSON).content(data))
			        .andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
