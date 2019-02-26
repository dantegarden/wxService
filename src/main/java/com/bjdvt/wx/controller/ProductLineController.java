package com.bjdvt.wx.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjdvt.wx.model.WxUser;

@RestController
@RequestMapping("/productLine")
public class ProductLineController {
	/*
	 private ProductLineMapper productLineMapper;
	 @RequestMapping("/list")
	 public List<ProductLine> list() {
		   return productLineMapper.selectByExample(null);
	       //return wxUserMapper.selectByExample(null);
	 }
	 @RequestMapping("/list/{productId}")
	 public List<ProductLine> list(@PathVariable("productId")int productId) {
		 ProductLineExample productExample=new ProductLineExample();
		
		 //productExample.createCriteria().andProductIdEqualTo(productId);
	
		 return productLineMapper.selectByExample(productExample);
	      
	 }*/
}
