package com.bjdvt.wx.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.websocket.server.PathParam;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.bjdvt.wx.controller.vo.MyShareVo;
import com.bjdvt.wx.controller.vo.ShareProductVo;
import com.bjdvt.wx.mapper.WxImageMapper;
import com.bjdvt.wx.model.Product;
import com.bjdvt.wx.model.WxImage;
import com.bjdvt.wx.model.WxUser;
import com.bjdvt.wx.serviceImp.ImageServiceImp;
import com.bjdvt.wx.serviceImp.ProductServiceImp;
import com.bjdvt.wx.serviceImp.WxUserServiceImp;
import com.bjdvt.wx.util.MyFileUtils;
import com.bjdvt.wx.util.WxResult;


/**
 * 图片处理
 * @author like
 *
 */
@RestController
@RequestMapping(value = "/image",produces = "application/json;charset=UTF-8")
public class ImageController {

	@Autowired
	private WxImageMapper wxImageMapper;
	
	@Value("${image.dir}")
	private String imageDir;
	@Autowired
	private ImageServiceImp imageServiceImp;
	@Autowired
	private WxUserServiceImp userServiceImp;
	@Autowired
	private ProductServiceImp productServiceImp;
	
	Logger logger = LoggerFactory.getLogger(ImageController.class);
	
	@RequestMapping(value="/upload")
	@ResponseBody
	public WxImage upload(@RequestParam("fileName") MultipartFile file,@RequestParam("userId") Integer userId){

		String fileName=MyFileUtils.getNewFileName(file.getOriginalFilename());
		String msg;
		System.out.println("userid="+userId);
        if (MyFileUtils.upload(file, imageDir, fileName)){
        	 WxImage wxImage=new WxImage();
             wxImage.setImageUrl(fileName);
             wxImage.setWxUserId(userId);
             wxImage.setCreateTime(new Date());
             wxImageMapper.insert(wxImage);
             wxImage.setCreateTime(null);
             System.out.println(wxImage.getId());
             return wxImage;

        }
        else {
        	return null;
        }
    }
	/**
	 * 获取微信的openid
	 * @throws IOException 
	 */
	@RequestMapping("/getImage/{id}/{url}")
	public ResponseEntity getWxSessionKey(@PathVariable("id")String id,@PathVariable("url")String url) throws IOException {
		return getWxSessionKey(id);
	}
	/**
	 * 获取微信的openid
	 * @throws IOException 
	 */
	@RequestMapping("/getImage/{id}")
	public ResponseEntity getWxSessionKey(@PathVariable("id")String id) throws IOException {
		System.out.println("id=="+id);
		String large=null;
		if(id.endsWith("large")) {
			String[] fileNames=id.split("_");
			large=fileNames[1];
			id=fileNames[0];
		}
		WxImage image=imageServiceImp.get(Integer.valueOf(id));
		File file;
		if(large!=null&&large.equals("large")) {
			file = new File(imageDir+"/"+image.getImageUrl());// 你放的文件路径 
		}
		else {
			
				file = new File(imageDir+"/less."+image.getImageUrl());// 你放的文件路径 
				if(!file.exists()) {
					file = new File(imageDir+"/"+image.getImageUrl());
				}
		
		}
		HttpHeaders headers = new HttpHeaders();// 设置一个head
		headers.setContentDispositionFormData("attachment", image.getImageUrl());// 文件的属性，也就是文件叫什么吧
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);// 内容是字节流
		//headers.add("Content-Disposition", "attchement;filename=" + image.getImageUrl());
		return new ResponseEntity<byte[]>(MyFileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
		

		
	}
	/**
	 * 获取微信的openid
	 * @throws IOException 
	 */
	@RequestMapping("/getImage/{id}/{url}/{width}/{height}")
	public ResponseEntity getScaleImage(@PathVariable("id")String id,@PathVariable("url")String url,@PathVariable("width")Integer wwidth,@PathVariable("height")Integer wheight) throws IOException {
		System.out.println("id=="+id);
		String large=null;
		if(id.endsWith("large")) {
			String[] fileNames=id.split("_");
			large=fileNames[1];
			id=fileNames[0];
		}
		WxImage image=imageServiceImp.get(Integer.valueOf(id));
		File file;
		if(large!=null&&large.equals("large")) {
			file = new File(imageDir+"/"+image.getImageUrl());// 你放的文件路径 
		}
		else {
			
				file = new File(imageDir+"/less."+image.getImageUrl());// 你放的文件路径 
				if(!file.exists()) {
					file = new File(imageDir+"/"+image.getImageUrl());
				}
				
		
		}
		BufferedImage bufImage = ImageIO.read(file);
		int height=bufImage.getHeight();
		int width=bufImage.getWidth();
		double scale=(double)(wwidth)/(double)(wheight);
		System.out.println("height"+height+" width="+width+" "+scale);
		if(width/height>scale) {
			width=(int)(height*scale);
		}else {
			height=(int)((double)(width)/scale);
		}
		System.out.println("height"+height+" width="+width);
		BufferedImage subImage =bufImage.getSubimage(0, 0, width, height);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write(subImage ,"jpg", out);
		HttpHeaders headers = new HttpHeaders();// 设置一个head
		headers.setContentDispositionFormData("attachment", image.getImageUrl());// 文件的属性，也就是文件叫什么吧
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);// 内容是字节流
		//headers.add("Content-Disposition", "attchement;filename=" + image.getImageUrl());
		return new ResponseEntity<byte[]>(out.toByteArray(), headers, HttpStatus.OK);
		

		
	}
	
	@RequestMapping("/getWxacodeun/{productId}/{fromUserId}/{ownerId}") 
	public WxImage getWxacodeun(@PathVariable("productId")Integer productId,@PathVariable("fromUserId")Integer fromUserId ,@PathVariable("ownerId")Integer ownerId) {
		WxImage image=imageServiceImp.getWxacodeun(productId, fromUserId, ownerId);
		
		return image;
	}
	@RequestMapping("/getShareProduct") 
	public ShareProductVo getShareProduct(@RequestBody MyShareVo myShareVo) {
		logger.info(" share productId"+myShareVo.getProductId());
		ShareProductVo shareProductVo=new ShareProductVo();
		WxImage image=imageServiceImp.getWxCodeImage(myShareVo.getProductId(), myShareVo.getFromUserId(), myShareVo.getOwnerId());
		logger.info("image"+image.getId());
		shareProductVo.setCodeUrl(image.getId()+"/"+image.getImageUrl());
		WxUser user=userServiceImp.get(myShareVo.getOwnerId());
		Product product=productServiceImp.get(myShareVo.getProductId());
		if(user.getAvatar()!=null){
			WxImage userImage= imageServiceImp.get(user.getAvatar());
			shareProductVo.setUserUrl(userImage.getId()+"/"+userImage.getImageUrl());
		}
		else {
			shareProductVo.setUserUrl("");
		}
		if(product.getProductImageList().size()>0) {
			
			WxImage productImage=imageServiceImp.get(product.getProductImageList().get(0).getImageId());
			shareProductVo.setProductUrl(productImage.getId()+"/"+productImage.getImageUrl());
		}
		else {
			shareProductVo.setProductUrl("");
		}
		logger.info("begin=="+shareProductVo.getProductUrl());
		return shareProductVo;
	}
}
