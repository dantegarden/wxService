package com.bjdvt.wx.serviceImp;

import java.awt.Color;
import java.awt.Font;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.bjdvt.wx.controller.vo.Line_color;
import com.bjdvt.wx.controller.vo.TokenResult;
import com.bjdvt.wx.controller.vo.WxacodeunVo;
import com.bjdvt.wx.mapper.ProductMapper;
import com.bjdvt.wx.mapper.WxImageMapper;
import com.bjdvt.wx.mapper.WxUserMapper;
import com.bjdvt.wx.model.Product;
import com.bjdvt.wx.model.WxImage;
import com.bjdvt.wx.util.MyFileUtils;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
@CacheConfig
@Service
public class ImageServiceImp {
	
	@Autowired
	private TokenService tokenService;
	@Autowired
	private WxImageMapper wxImageMapper;
	@Autowired
	private ProductServiceImp productServiceImp;
	@Autowired
	private HttpServiceImp httpServiceImp;
	@Value("${image.dir}")
	private String imageDir;
	Logger logger = LoggerFactory.getLogger(ImageServiceImp.class);
	
	@Cacheable(value={"image"}, key="#id")
	public WxImage get(Integer id) {
		return wxImageMapper.selectByPrimaryKey(id);
	}
	public WxImage getWxacodeun(Integer productId,Integer fromUser ,Integer ownerId) {
		TokenResult tokenResult=tokenService.getToken("token");
		Date date=new Date();
		logger.info("timeout="+tokenResult.getTimeout());
		logger.info("date="+date);
		if(tokenResult.getTimeout()==null||date.after(tokenResult.getTimeout())) {
			tokenResult=tokenService.getNewToken("token");
		}
		 System.out.println(tokenResult.getAccess_token());
         Map<String, Object> params = new HashMap<>();
         params.put("scene", productId+"&"+fromUser+"&"+ownerId);
         params.put("page", "pages/product_detail/detail");
         params.put("width", 430);
         
         CloseableHttpClient  httpClient = HttpClientBuilder.create().build();

         HttpPost httpPost = new HttpPost("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token="+tokenResult.getAccess_token());
         httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
         String body = JSON.toJSONString(params);
         StringEntity entity;
         FileOutputStream out=null;
         try {
			entity = new StringEntity(body);
		
         entity.setContentType("image/png");

         httpPost.setEntity(entity);
         HttpResponse response;

         response = httpClient.execute(httpPost);
         InputStream inputStream = response.getEntity().getContent();
         String fileName=MyFileUtils.getNewFileName("test.png");
         logger.info("111"+fileName);
          out = new FileOutputStream(imageDir+"/"+fileName);

         byte[] buffer = new byte[8192];
         int bytesRead = 0;
         while((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
             out.write(buffer, 0, bytesRead);
         }

         out.flush();
         out.close();
         Product product=productServiceImp.get(productId);
        return  writeImge(ownerId,imageDir+"/"+fileName,product);
         } catch (UnsupportedEncodingException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally {
        	if(out!=null) {
        		try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
		return null;
		
		
	}
	
	public WxImage getWxCodeImage(Integer productId,Integer fromUser ,Integer ownerId) {
		TokenResult tokenResult=tokenService.getToken("token");
		Date date=new Date();
		if(tokenResult.getTimeout()==null||date.after(tokenResult.getTimeout())) {
			tokenResult=tokenService.getNewToken("token");
		}
		 System.out.println(tokenResult.getAccess_token());
         Map<String, Object> params = new HashMap<>();
         params.put("scene", productId+"&"+fromUser+"&"+ownerId);
         params.put("page", "pages/product_detail/detail");
         params.put("width", 430);
         
         CloseableHttpClient  httpClient = HttpClientBuilder.create().build();

         HttpPost httpPost = new HttpPost("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token="+tokenResult.getAccess_token());
         httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
         String body = JSON.toJSONString(params);
         StringEntity entity;
         FileOutputStream out=null;
         try {
			entity = new StringEntity(body);
		
         entity.setContentType("image/png");

         httpPost.setEntity(entity);
         HttpResponse response;

         response = httpClient.execute(httpPost);
         InputStream inputStream = response.getEntity().getContent();
         String fileName=MyFileUtils.getNewFileName("test.png");
         
          out = new FileOutputStream(imageDir+"/"+fileName);

         byte[] buffer = new byte[8192];
         int bytesRead = 0;
         while((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
             out.write(buffer, 0, bytesRead);
         }

         out.flush();
         out.close();
        
 		 WxImage wxImage=new WxImage();
         wxImage.setImageUrl(fileName);
         wxImage.setWxUserId(ownerId);
         wxImage.setCreateTime(new Date());
         wxImageMapper.insert(wxImage);
         return wxImage;
       
         } catch (UnsupportedEncodingException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally {
        	if(out!=null) {
        		try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
		return null;
		
		
	}
	
	
	
	private WxImage writeImge(Integer userId,String wxcodeImageFileName,
			Product product) {
		try {
		int width = 750;
		int height = 1330;
		String content = product.getProductName();
		String advertising = product.getAdvertising();
		String fileName=MyFileUtils.getNewFileName("test.jpg");
		logger.info("222filename="+fileName);
		File file = new File(imageDir+"/"+fileName);
	
		BufferedImage imageLocal=null;
		if(product.getProductImageList().size()>0) {
			Integer imageId=product.getProductImageList().get(0).getImageId();
			WxImage image=wxImageMapper.selectByPrimaryKey(imageId);
			imageLocal = ImageIO.read(new File(imageDir+"/"+image.getImageUrl()));
		}
		BufferedImage imageCode=null;
		if(product.getProductImageList().size()>0) {
		
			imageCode = ImageIO.read(new File(wxcodeImageFileName));
		}
		BufferedImage bufferedImage = new BufferedImage(
					width, 
					height, 
					BufferedImage.TYPE_INT_RGB
				);
			
		Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();
		graphics2D.setBackground(Color.WHITE);
		graphics2D.clearRect(0, 0, width, height);
		graphics2D.setPaint(Color.RED);
		
		if(imageLocal!=null) {
			graphics2D.drawImage(imageLocal, 0,0,750,750,null);
		}
		Font font = new Font("Serif", Font.BOLD, 20);
		graphics2D.setFont(font);
		graphics2D.setColor(Color.RED);
		if(product.getCurrentPrice()!=null) {
			graphics2D.drawString("¥"+product.getCurrentPrice(),30,780);
		}
		if(product.getOriginalPrice()!=null) {
			Font font2 = new Font("Serif", Font.BOLD, 18);
			graphics2D.setFont(font2);
			graphics2D.setColor(Color.black);
			String buf=product.getCurrentPrice().toString();
			graphics2D.drawString("["+product.getOriginalPrice()+"]",38+buf.length()+70,780);
		}
		if(imageCode!=null) {
			graphics2D.drawImage(imageCode, 450,900,250,250,null);
		}
		int num=0;
		if(product.getProductName()!=null) {
			Font font2 = new Font("Serif", Font.BOLD, 18);
			graphics2D.setFont(font2);
			graphics2D.setColor(Color.black);
			List<String> nameList=GetStringRows(graphics2D,font2,product.getProductName(),700);
			
			for(String str:nameList)
			{
			
				graphics2D.drawString(str,10,810+num*30);
				num++;
			}
		}
		
		if(product.getAdvertising()!=null) {
			Font font2 = new Font("Serif", Font.BOLD, 14);
			graphics2D.setFont(font2);
			graphics2D.setColor(Color.red);
			List<String> nameList=GetStringRows(graphics2D,font2,product.getAdvertising(),300);
			for(String str:nameList)
			{
				graphics2D.drawString(str,10,810+num*30);
				num++;
			}
		}
		
		// 1.将图片写到实体图片里 
		ImageIO.write(bufferedImage, "jpg", file);
		WxImage wxImage=new WxImage();
        wxImage.setImageUrl(fileName);
        wxImage.setWxUserId(userId);
        wxImage.setCreateTime(new Date());
        wxImageMapper.insert(wxImage);
        return wxImage;
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			
		}
		return null;
		
			

	}
	
	/// <summary>
	/// 将文本分行
	/// </summary>
	/// <param name=\"graphic\">绘图图面</param>
	/// <param name=\"font\">字体</param>
	/// <param name=\"text\">文本</param>
	/// <param name=\"width\">行宽</param>
	/// <returns></returns>
	private List<String> GetStringRows(Graphics2D graphic, Font font, String text, int width)
	{
	int RowBeginIndex = 0;
	int rowEndIndex = 0;
	int textLength = text.length();
	List<String> textRows = new LinkedList<String>();
	for (int index = 0; index < textLength; index++)
	{
		rowEndIndex = index;
		if (index == textLength - 1)
		{
			textRows.add(text.substring(RowBeginIndex));
		}
		else if (rowEndIndex + 1 < text.length() && text.substring(rowEndIndex, rowEndIndex+1) == "\\n")
		{
			textRows.add(text.substring(RowBeginIndex, rowEndIndex ));
			rowEndIndex=index += 1;
			RowBeginIndex = rowEndIndex;
	
		}
		else if (graphic.getFontMetrics().getStringBounds(text.substring(RowBeginIndex, rowEndIndex + 1), null).getWidth() > width)
		{
			textRows.add(text.substring(RowBeginIndex, rowEndIndex ));	
			RowBeginIndex = rowEndIndex;
		}
	}
	return textRows;
	}
	
}
