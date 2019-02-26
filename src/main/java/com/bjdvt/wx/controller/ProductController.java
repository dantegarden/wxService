package com.bjdvt.wx.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.bjdvt.wx.controller.vo.ProductVo;
import com.bjdvt.wx.controller.vo.SaveProductVo;
import com.bjdvt.wx.model.Product;
import com.bjdvt.wx.model.WxUser;
import com.bjdvt.wx.model.WxUserExample;
import com.bjdvt.wx.serviceImp.ProductServiceImp;


@RestController
@RequestMapping("/product")
public class ProductController {

	Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired	
	 private ProductServiceImp productServiceImp;
	
	 
	 @RequestMapping("/showAll/{userId}")
	 public List<ProductVo> shouAll(@PathVariable("userId") Integer userId) {
		 List<Product> productList=productServiceImp.getAll(userId);
		 List<ProductVo> productVoList=new ArrayList();
		 for(Product product:productList) {
			 ProductVo productVo=new ProductVo();
			 product.setProductId(product.getId());
			 productVo.setAdvertising(product.getAdvertising());
			 productVo.setCurrentPrice((Double.valueOf(product.getCurrentPrice())));
			 productVo.setOriginalPrice(Double.valueOf(product.getOriginalPrice()));
			 productVo.setProductId(product.getId());
			 productVo.setProductName(product.getProductName());
			 productVo.setCompanyId(product.getCompanyId());
			 productVo.setOrderNum(product.getOrdernum());
			 productVo.setStatus(product.getStatus());
			 if(product.getProductImageList().size()>0) {
				 productVo.setPoster(product.getProductImageList().get(0).getImageId());
			 }
			 productVoList.add(productVo);
		 }
		 return productVoList;
	 }
	 @RequestMapping("/showAllOnSale/{userId}")
	 public List<ProductVo> shouAllOnSale(@PathVariable("userId") Integer userId) {
		 List<Product> productList=productServiceImp.getAllOnSale(userId);
		 List<ProductVo> productVoList=new ArrayList();
		 for(Product product:productList) {
			 ProductVo productVo=new ProductVo();
			 product.setProductId(product.getId());
			 productVo.setAdvertising(product.getAdvertising());
			 productVo.setCurrentPrice((Double.valueOf(product.getCurrentPrice())));
			 productVo.setOriginalPrice(Double.valueOf(product.getOriginalPrice()));
			 productVo.setProductId(product.getId());
			 productVo.setProductName(product.getProductName());
			 productVo.setCompanyId(product.getCompanyId());
			 productVo.setOrderNum(product.getOrdernum());
			 productVo.setStatus(product.getStatus());
			 if(product.getProductImageList().size()>0) {
				 productVo.setPoster(product.getProductImageList().get(0).getImageId());
			 }
			 productVoList.add(productVo);
		 }
		 return productVoList;
	 }
	 
	 @RequestMapping("/show/{producId}")
	 public Product show(@PathVariable("producId") Integer productId ) {
		 Product product=productServiceImp.get(productId);
		 product.setProductId(product.getId());
		 if(product.getProductImageList().size()>0) {
			 product.setPoster(product.getProductImageList().get(0).getImageId());
		 }
		 logger.info(JSON.toJSONString(product));
		 return product;
		 
	 }
	 @RequestMapping(value="/save" , method = RequestMethod.POST)
	 public Product save(@RequestBody SaveProductVo  productVo ) {
		// SaveProductVo productVo=JSON.parseObject(productStr,SaveProductVo.class);
		 Product product=productVo.getProduct();
		 //logger.info("save productStr="+productStr);
		 logger.info("save productId="+product.getProductName());
		 logger.info("save getOriginalPrice="+product.getOriginalPrice());
		 logger.info("save getAdvertising="+product.getAdvertising());
		 logger.info("save getCurrentPrice="+product.getCurrentPrice());
		 product.setId(product.getProductId());
		 productServiceImp.saveProduct(product,productVo.getUserId());
		 return product;
		 
	 }
	 
	 @RequestMapping(value="/delete/{producId}" )
	 public String delete(@PathVariable("producId")Integer productId ) {
		 logger.info("delete productId="+productId);
		 productServiceImp.deleteProduct(productId);
		 return "Success";
	 }
	 
	 @RequestMapping(value="/change/status/{status}/{producId}" )
	 public String changeStatus(@PathVariable("status")Integer status,@PathVariable("producId")Integer productId ) {
		 logger.info("changeStatus productId="+productId);
		 productServiceImp.changeStatus(productId,status);
		 return "Success";
	 }
	
	 @RequestMapping(value="/change/order/{order}/{producId}" )
	 public String changeOrder(@PathVariable("order")String order,@PathVariable("producId")Integer productId ) {
		 logger.info("changeStatus productId="+productId);
		 productServiceImp.changeOrder(productId,order);
		 return "Success";
	 }
	 
	
}
