package com.bjdvt.wx.serviceImp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bjdvt.wx.mapper.ProductDescribeImagesMapper;
import com.bjdvt.wx.mapper.ProductDescribeMapper;
import com.bjdvt.wx.mapper.ProductImageMapper;
import com.bjdvt.wx.mapper.ProductMapper;
import com.bjdvt.wx.mapper.WxUserMapper;
import com.bjdvt.wx.model.Product;
import com.bjdvt.wx.model.ProductDescribe;
import com.bjdvt.wx.model.ProductDescribeExample;
import com.bjdvt.wx.model.ProductDescribeImages;
import com.bjdvt.wx.model.ProductDescribeImagesExample;
import com.bjdvt.wx.model.ProductExample;
import com.bjdvt.wx.model.ProductImage;
import com.bjdvt.wx.model.ProductImageExample;
import com.bjdvt.wx.model.WxUser;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class ProductServiceImp {
	@Autowired
	private ProductDescribeMapper productDescribeMapper;
	@Autowired
	private ProductDescribeImagesMapper productDescribeImagesMapper;
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private ProductImageMapper productImageMapper;
	@Autowired
	private WxUserMapper wxUserMapper;
	@Autowired
	private WxUserServiceImp wxUserServiceImp;
	
	/**
	 * 显示所有产品
	 * @param userId
	 * @return
	 */
	public List <Product> getAll(Integer userId) {
		WxUser wxUser=wxUserMapper.selectByPrimaryKey(userId);
		List<Product> productList=getProductsOrder(wxUser.getWxCompanyId());
		for(Product product:productList) {
			List<ProductImage> productImageList=getProductImages(product.getId());
			product.setProductImageList(productImageList);
		}
		return productList;
	}
	/**
	 * 显示所有上架产品
	 * @param userId
	 * @return
	 */
	public List <Product> getAllOnSale(Integer userId) {
		WxUser wxUser=wxUserMapper.selectByPrimaryKey(userId);
		ProductExample productExample=new ProductExample();
		productExample.createCriteria().andCompanyIdEqualTo(wxUser.getWxCompanyId())
		 .andStatusEqualTo(1);
		productExample.setOrderByClause("  status desc,orderNum");
		List<Product> productList=productMapper.selectByExample(productExample);
		for(Product product:productList) {
			List<ProductImage> productImageList=getProductImages(product.getId());
			product.setProductImageList(productImageList);
		}
		return productList;
	}
	public List<Product> getProductsOrder(Integer companyId){
		ProductExample productExample=new ProductExample();
		productExample.createCriteria().andCompanyIdEqualTo(companyId);
		productExample.setOrderByClause(" status desc,orderNum");
		List<Product> productList=productMapper.selectByExample(productExample);
		return productList;
	}
	/**
	 * 显示单个产品
	 * @param productId
	 * @return
	 */
	public Product get(Integer productId) {
		Product product=productMapper.selectByPrimaryKey(productId);
		List<ProductImage> productImageList=getProductImages(product.getId());
		product.setProductImageList(productImageList);
		
		List<ProductDescribe>  productDescribeList=getProductDescribes(product.getId());
		product.setProductDescribeList(productDescribeList);
		return product;
	}
	/**
	 * 保存产品
	 * @param product
	 */
	public void saveProduct(Product product,Integer userId) {
		WxUser wxUser= wxUserServiceImp.get(userId);
		if(product.getId()==null) {
			product.setWxUserId(wxUser.getId());
			product.setCompanyId(wxUser.getWxCompanyId());
			product.setCreateTime(new Date());
			product.setStatus(0);
			List<Product> productList=getProductsOrder(wxUser.getWxCompanyId());
			if(productList.size()>0) {
				Product p=productList.get(productList.size()-1);
				product.setOrdernum(p.getOrdernum()+20);
			}else {
				product.setOrdernum(1);
			}
			productMapper.insert(product);
		}else {
			Product productold=get(product.getId());
			for(ProductImage productImage:productold.getProductImageList() ) {
				deleteProductImage(productImage);
			}
			for(ProductDescribe productDescribe:productold.getProductDescribeList()) {
				deleteProductDescribe(productDescribe);
				
			}
			productMapper.updateByPrimaryKey(product);
			
		}
		for(ProductImage productImage:product.getProductImageList() ) {
			productImage.setProductId(product.getId());
			productImage.setWxUserId(wxUser.getId());
			productImage.setCreateTime(new Date());
			productImage.setCompanyId(wxUser.getWxCompanyId());
			saveProductImage(productImage);
		}
		for(ProductDescribe productDescribe:product.getProductDescribeList()) {
			productDescribe.setProductId(product.getId());
			productDescribe.setWxUserId(wxUser.getId());
			productDescribe.setCompanyId(wxUser.getWxCompanyId());
			productDescribe.setCreateTime(new Date());
			saveproductDescribe(productDescribe,wxUser);
		}
	}
	/**
	 * 删除产品
	 * @param productId
	 */
	public void deleteProduct(Integer productId) {
		Product product=get(productId);
		
		for(ProductImage productImage:product.getProductImageList() ) {
			deleteProductImage(productImage);
		}
		for(ProductDescribe productDescribe:product.getProductDescribeList()) {
			deleteProductDescribe(productDescribe);
			
		}
		productMapper.deleteByPrimaryKey(productId);
	}
	/**
	 * 上下架产品
	 * @param productId
	 */
	public void changeStatus(Integer productId,Integer status) {
		Product product=new Product();
		product.setId(productId);
		product.setStatus(status);
		productMapper.updateByPrimaryKeySelective(product);
	}
	/**
	 * 调整产品顺序
	 * @param productId
	 */
	public void changeOrder(Integer productId,String order) {
		Product product=get(productId);
		//product.setId(productId);

		
		ProductExample productExample=new ProductExample();
		productExample.createCriteria().andCompanyIdEqualTo(product.getCompanyId())
		 .andStatusEqualTo(1);
		productExample.setOrderByClause("  orderNum");
		List<Product> productList=productMapper.selectByExample(productExample);
		
		Product preProduct=null;
		Product nextProduct=null;
		for(int i=0;i<productList.size();i++) {
			Product tmpProduct=productList.get(i);
			if(productId.equals(tmpProduct.getId())) {
				if(order.equals("up")) {
					if(i>0) {
						preProduct=productList.get(i-1);
					}
					if(preProduct!=null) {
						Integer currOrderNum=product.getOrdernum();
						product.setOrdernum(preProduct.getOrdernum());
						preProduct.setOrdernum(currOrderNum);
						productMapper.updateByPrimaryKey(preProduct);
						productMapper.updateByPrimaryKey(product);
					}
				}
				else {
					if(i<productList.size()-1) {
						nextProduct=productList.get(i+1);
					}
					if(nextProduct!=null) {
						Integer currOrderNum=product.getOrdernum();
						product.setOrdernum(nextProduct.getOrdernum());
						nextProduct.setOrdernum(currOrderNum);
						productMapper.updateByPrimaryKey(nextProduct);
						productMapper.updateByPrimaryKey(product);
					}
				}
			}
			
		}
		
	}
	public void upProudctOrder(Product product,List<Product> preProductList) {
		
	}
	
	private void deleteProductDescribe(ProductDescribe productDescribe) {
		productDescribeMapper.deleteByPrimaryKey(productDescribe.getId());
		for(ProductDescribeImages productDescribeImages:productDescribe.getProductDescribeListImages()) {
			deleteProductDescribeImages(productDescribeImages);
		}
	}
	private void deleteProductDescribeImages(ProductDescribeImages productDescribeImages) {
		productDescribeImagesMapper.deleteByPrimaryKey(productDescribeImages.getId());
	}
	private void deleteProductImage(ProductImage productImage) {
		productImageMapper.deleteByPrimaryKey(productImage.getId());
	}
	private void saveproductDescribe(ProductDescribe productDescribe,WxUser wxUser) {
		
		productDescribeMapper.insert(productDescribe);
		
		for(ProductDescribeImages productDescribeImages:productDescribe.getProductDescribeListImages()) {
			productDescribeImages.setProductDescirbeId(productDescribe.getId());

			productDescribeImages.setWxUserId(wxUser.getId());
			productDescribeImages.setCompanyId(wxUser.getWxCompanyId());
			productDescribeImages.setCreateTime(new Date());
			saveProductDescribeImages(productDescribeImages);
		}
	}
	
	private void saveProductDescribeImages(ProductDescribeImages productDescribeImages) {
		
			productDescribeImagesMapper.insert(productDescribeImages);
		
	}
	private void saveProductImage(ProductImage productImage) {
		
			productImageMapper.insert(productImage);
		
	}
	/**
	 *  根据产品ID获取图片信息
	 * @param productId
	 * @return
	 */
	private	List<ProductImage> getProductImages(Integer  productId){
		ProductImageExample productImageExample=new ProductImageExample();
		productImageExample.createCriteria().andProductIdEqualTo(productId);
		productImageExample.setOrderByClause(" id");
		List<ProductImage> productImageList=productImageMapper.selectByExample(productImageExample);
		return productImageList;
	}
	
	
	/**
	 * 查找产品介绍
	 * @param productId
	 * @return
	 */
	private List<ProductDescribe> getProductDescribes(Integer productId){
		
		
		ProductDescribeExample productDescribeExample=new ProductDescribeExample();
		productDescribeExample.createCriteria().andProductIdEqualTo(productId);
		productDescribeExample.setOrderByClause("id");
		List<ProductDescribe> productDescribeList=productDescribeMapper.selectByExample(productDescribeExample);
		for(ProductDescribe productDescribe:productDescribeList) {
			//前台需要key和Id保持一致
			 productDescribe.setKey(productDescribe.getId().toString());
			 List<ProductDescribeImages> productDescribeImagesList=getProductDescribeImages(productDescribe.getId());
			 productDescribe.setProductDescribeListImages(productDescribeImagesList);
		}
		

		return productDescribeList;
	}
	 
	private List<ProductDescribeImages> getProductDescribeImages(Integer productDescribeId){
		ProductDescribeImagesExample productDescribeImagesExample=new ProductDescribeImagesExample();
		productDescribeImagesExample.createCriteria().andProductDescirbeIdEqualTo(productDescribeId);
		List<ProductDescribeImages> productDescribeImagesList=productDescribeImagesMapper.selectByExample(productDescribeImagesExample) ;
		return productDescribeImagesList;
	}
	
	
}