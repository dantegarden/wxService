package com.bjdvt.wx.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.alibaba.fastjson.JSON;
import com.bjdvt.wx.model.WxImage;
import com.bjdvt.wx.util.WxResult;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ImageControllerTest {

	private MockMvc mvc;
	 
	@Autowired
	private UserController userController;
	
	@Before
    public void setUp(){
		System.out.println("begin");
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }
	
	@Test
	public void uploadImage() {
		//MockMultipartFile firstFile = new MockMultipartFile("data", "/Users/like/Downloads/12444.png", "text/plain", "some xml".getBytes());  
		WxImage wxresult = JSON.parseObject("{\"id\":29,\"imageUrl\":\"49c93e093a534367b145c6d190bcbaec.jpg\",\"wxUserId\":2,\"companyId\":1,\"createTime\":\"2018-07-12T01:21:42.655+0000\"}",WxImage.class); 
		try {
			MockMultipartFile mockMultipartFile    = new MockMultipartFile("12444.png", new FileInputStream(new File("/Users/like/Downloads/12444.png")));
		     
			
			
			mvc.perform(MockMvcRequestBuilders.fileUpload("http://localhost:8080/image/upload")  
			                .file(mockMultipartFile)  
			                .param("userid", "1"))  
	        .andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
}
