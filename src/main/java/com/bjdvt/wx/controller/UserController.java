package com.bjdvt.wx.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import com.alibaba.fastjson.*;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bjdvt.wx.controlModel.User;
import com.bjdvt.wx.controller.vo.GamInfo;
import com.bjdvt.wx.controller.vo.GamResult;
import com.bjdvt.wx.controller.vo.GamVo;
import com.bjdvt.wx.controller.vo.MyContract;
import com.bjdvt.wx.controller.vo.MyShareVo;
import com.bjdvt.wx.controller.vo.SkimDayNumVo;
import com.bjdvt.wx.controller.vo.SkimProductVo;
import com.bjdvt.wx.controller.vo.SkimVisitVo;
import com.bjdvt.wx.controller.vo.TokenResult;
import com.bjdvt.wx.controller.vo.UserVo;
import com.bjdvt.wx.controller.vo.VisitVo;
import com.bjdvt.wx.exception.CustomException;
import com.bjdvt.wx.mapper.*;
import com.bjdvt.wx.model.WxCompany;
import com.bjdvt.wx.model.WxImageExample;
import com.bjdvt.wx.model.WxMyuser;
import com.bjdvt.wx.model.WxMyuserExample;
import com.bjdvt.wx.model.WxUser;
import com.bjdvt.wx.model.WxUserExample;
import com.bjdvt.wx.serviceImp.DbServiceImp;
import com.bjdvt.wx.serviceImp.HttpServiceImp;
import com.bjdvt.wx.serviceImp.WxUserServiceImp;
import com.bjdvt.wx.util.AccessToken;
import com.bjdvt.wx.util.AudienceEntity;
import com.bjdvt.wx.util.GrantedAuthorityImpl;
import com.bjdvt.wx.util.JwtHelper;
import com.bjdvt.wx.util.ResultMsg;
import com.bjdvt.wx.util.ResultStatusCode;
import com.bjdvt.wx.util.Util;
import com.bjdvt.wx.util.WxResult;


import com.bjdvt.wx.mapper.WxUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.bjdvt.wx.mapper.WxUserMapper;
@RestController
@RequestMapping(value = "/user",produces = "application/json;charset=UTF-8")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class UserController {
	@Value("${appid}")
	private final String appid = "wxc86f79eeb8fdb588";
	@Value("${secret")
	private final String secret = "e342678231774050626e7991c88e1012";

	@Autowired
	private WxUserMapper wxUserMapper;
	
	@Autowired
	private HttpServiceImp httpServiceImp;
	
	private AudienceEntity audienceEntity = new AudienceEntity();
	@Autowired
	private DbServiceImp dbServiceImp;
	
	@Autowired
	private WxCompanyMapper wxCompanyMapper;
	
	@Autowired
	private WxUserServiceImp wxUserServiceImp;
	
	@Autowired
	private WxMyuserMapper wxMyuserMapper;
	Logger logger = LoggerFactory.getLogger(UserController.class);
	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
	
//	@ExceptionHandler(CustomException.class)
//	public ResponseEntity<Error> UserNotFound(CustomException e){
//	   logger.info("111111111111111111111111111111111111");
//	    Error error = new Error(e);
//	    return new ResponseEntity<Error>(error,HttpStatus.BAD_REQUEST);
//	}

	@RequestMapping("/list")
	public List<WxUser> userList() {
		return dbServiceImp.getUsers();
		// return wxUserMapper.selectByExample(null);
	}
	
	/**
	 * 获取数据库中的用户
	 * 
	 * @param id
	 * @return
	 */
	/*
	 * @RequestMapping("/get/{id}") public WxUser getUser(@PathVariable("id")int
	 * id){
	 * 
	 * WxUser wxUser=wxUserMapper.(id); System.out.println(wxUser); return wxUser;
	 * 
	 * }
	 */
	/**
	 * 根据微信id查找用户
	 * 
	 * @param id
	 * @return
	 */
	/*
	 * @RequestMapping("/getUserByWx/{wxid}") public List<WxUser>
	 * getUserByWx(@PathVariable("wxid")int wxid){ WxUserExample wxUserExample=new
	 * WxUserExample(); wxUserExample.createCriteria().andWxIdEqualTo(wxid);
	 * List<WxUser> wxUserList=wxUserMapper.selectByExample(wxUserExample); return
	 * wxUserList;
	 * 
	 * }
	 */
	@RequestMapping("/login/{name}/{passwd}")
	public AccessToken getAccessToken(@PathVariable("name") String name, @PathVariable("passwd") String passwd) {
		ResultMsg resultMsg;

		
			ArrayList<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add( new GrantedAuthorityImpl("NORMAL"));
			// 拼装accessToken
			String accessToken = JwtHelper.createJWT(name, audienceEntity.getClientId(), audienceEntity.getName(),
					audienceEntity.getExpiresSecond() * 1000, audienceEntity.getBase64Secret(),authorities);

			// 返回accessToken
			AccessToken accessTokenEntity = new AccessToken();
			accessTokenEntity.setAccess_token(accessToken);
			accessTokenEntity.setExpires_in(audienceEntity.getExpiresSecond());
			accessTokenEntity.setToken_type("bearer");
			
			return accessTokenEntity;

		
	}
	
	
	/**
	 * 获取微信的openid
	 */
	@RequestMapping("/getWxSessionKey/{jscode}")
	public WxResult getWxSessionKey(@PathVariable("jscode")String jscode) {
		
		logger.info("SpringBoot开始加载");
		String url = "https://api.weixin.qq.com/sns/jscode2session";
		Map<String, Object> paramsMap = new HashMap();
		paramsMap.put("appid", appid);
		paramsMap.put("secret", secret);
		paramsMap.put("js_code", jscode);
		paramsMap.put("grant_type", "authorization_code");
		String result=httpServiceImp.get(url, paramsMap);
		logger.info("wxresult="+result);
		WxResult wxresult = JSON.parseObject(result,WxResult.class);
		
		if (wxresult.getOpenid()!=null) {
			//查找用户是否存在，如果不存在插入用户
			WxUser wxUser=wxUserMapper.selectByOpenId(wxresult.getOpenid());
			wxresult.setOpenid(wxresult.getOpenid());
			if(wxUser==null) {
				wxUser=new WxUser();
				wxUser.setWxId(wxresult.getOpenid());
				wxUser.setCreateTime(new Date());
				wxUserMapper.insert(wxUser);
				System.out.println("wx="+wxUser);
				System.out.println("wx="+wxUser.getId());
				wxresult.setUserId(wxUser.getId());
				wxresult.setRole(1);
				wxresult.setFlag(0);
				
			}
			else {
				if(wxUser.getWxCompanyId()!=null) {
					wxresult.setFlag(1);
					wxresult.setCompanyId(wxUser.getWxCompanyId());
					wxresult.setRole(wxUser.getRole());
					wxresult.setUserId(wxUser.getId());
					
				}
				else {
					wxresult.setFlag(0);
					wxresult.setRole(1);
					wxresult.setUserId(wxUser.getId());
				}
			
			}
			ArrayList<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add( new GrantedAuthorityImpl("NORMAL"));
            if(wxresult.getRole()==1) {
            	authorities.add( new GrantedAuthorityImpl("ADMIN"));
            }
			String accessToken = JwtHelper.createJWT(String.valueOf(wxresult.getUserId()), audienceEntity.getClientId(), audienceEntity.getName(),
					audienceEntity.getExpiresSecond() * 1000, audienceEntity.getBase64Secret(),authorities);

			// 返回accessToken
			wxresult.setExpires_in(audienceEntity.getExpiresSecond() * 1000);
			wxresult.setAccessToken(accessToken);
			return wxresult;
		}
		throw new CustomException(100,"not found user"); 
		
		
		
	}
	/**
	 * 保存用户信息
	 */
	
	@RequestMapping("/save")
	public WxUser save(@RequestBody UserVo userVo) {
	
		String str=JSON.toJSONString(userVo);
		System.out.println(str);
		User user=JSON.parseObject(str, User.class);
	
		WxCompany wxCompany=new WxCompany();
		//int role=0;
		if(user.getCompanyId()==null) {
			wxCompany.setCreateTime(new Date());
			wxCompany.setName(user.getCompany());
			wxCompany.setCompanyaddress(user.getCompanyAddress());
			wxCompany.setCreateTime(new Date());
			wxCompanyMapper.insert(wxCompany);
			//role=1;
			
		}
		else {
			wxCompany=wxCompanyMapper.selectByPrimaryKey(user.getCompanyId());
			wxCompany.setName(user.getCompany());
			wxCompany.setCompanyaddress(user.getCompanyAddress());
			wxCompanyMapper.updateByPrimaryKey(wxCompany);
			//role=0;
			
		}
		
		
		WxUser wxuser=wxUserMapper.selectByPrimaryKey(user.getUserId());
		if(user.getCompanyId()==null) {
			wxuser.setRole(1);
		}
		wxuser.setAvatar(user.getAvatar());
		wxuser.setCreateId(user.getUserId());
		wxuser.setEmail(user.getCompanyEmail());
		wxuser.setName(user.getLoginName());
		wxuser.setJob(user.getJob());
		wxuser.setPhone(user.getPhone());
		wxuser.setCreateTime(new Date());
		wxuser.setSignature(user.getSignature());
		wxuser.setWxCompanyId(wxCompany.getId());
		wxuser.setIntroductionTitle(user.getIntroductionTitle());
		wxuser.setSignatureTitle(user.getSignatureTitle());
		wxuser.setAddress(user.getCompanyAddress());
		wxuser.setIntroductionimg(user.getIntroductionImg());
		wxuser.setIntroduction(user.getIntroduction());
		wxuser.setIntroductionTitle(user.getIntroductionTitle());
		wxuser.setSignatureTitle(user.getSignatureTitle());
		
		wxUserServiceImp.saveWxUser(wxuser);
		return 	wxuser;
		
	}
	/**
	 * 显示用户信息
	 */
	@RequestMapping("/show/{id}")
	public User show(@PathVariable("id") Integer userId) {
		logger.info("show id="+userId);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userid=authentication.getName();
		logger.info("show id="+userid);
		WxUser wxUser=wxUserServiceImp.getWxUser(userId);
		User user=changeToUser(wxUser);
		return user;
	}
	
	/**
	 * 显示用户信息
	 */
	@RequestMapping("/showAll/{id}")
	public List<User> showAll(@PathVariable("id") Integer userId) {
		logger.info("showAll id="+userId);
		WxUser wxuser=wxUserMapper.selectByPrimaryKey(userId);
		WxMyuserExample xMyuserExample=new WxMyuserExample();
		xMyuserExample.createCriteria().andMyUserIdEqualTo(wxuser.getId());
		List<WxMyuser>  wxMyuserList=wxMyuserMapper.selectByExample(xMyuserExample);
		List<User> userList=new ArrayList<User>();
		WxMyuser my=new WxMyuser();
		my.setWxUserId(wxuser.getId());
		my.setMyUserId(wxuser.getId());
		wxMyuserList.add(my);
		
		WxMyuser kefu=new WxMyuser();
		kefu.setWxUserId(1);
		kefu.setMyUserId(wxuser.getId());
		wxMyuserList.add(0, kefu);
		
		for(WxMyuser wxMyuser :wxMyuserList) {
			WxUser myuser=wxUserMapper.selectByPrimaryKey(wxMyuser.getWxUserId());
			User user=changeToUser(myuser);
			if(user.getUserId().equals(userId)) {
				user.setContacttype(0);
			}else if(user.getCompanyId().equals(wxuser.getWxCompanyId())) {
				user.setContacttype(1);
			}else {
				user.setContacttype(2);
			}
			userList.add(user);
		}
		WxUserExample wxUserExample=new WxUserExample();
		wxUserExample.createCriteria().andWxCompanyIdEqualTo(wxuser.getWxCompanyId());
		logger.info("CompanyId id="+wxuser.getWxCompanyId());
		List<WxUser> togetherList= wxUserMapper.selectByExample(wxUserExample);
		for(WxUser tmpUser:togetherList) {
			boolean isExist=false;
			logger.info("wxUser id="+tmpUser.getId());
			for(User myUser:userList) {
				if(myUser.getUserId().equals(tmpUser.getId())){
					isExist=true;
					break;
				}
			}
			if(isExist==false) {
				User user=changeToUser(tmpUser);
				user.setContacttype(1);
				userList.add(user);
			}
		}
		
		
		return userList;
		
	}
	
	
	private User changeToUser(WxUser myuser) {
		
		WxCompany wxCompany=wxCompanyMapper.selectByPrimaryKey(myuser.getWxCompanyId());
		
		User user=new User();
		user.setAvatar(myuser.getAvatar());
		user.setCompany(wxCompany.getName());
		user.setIntroductionImg(myuser.getIntroductionimg());
		user.setCompanyAddress(myuser.getAddress());
		user.setCompanyId(myuser.getWxCompanyId());
		user.setUserId(myuser.getId());
		user.setCompanyEmail(myuser.getEmail());
		user.setJob(myuser.getJob());
		user.setLoginName(myuser.getName());
		user.setPhone(myuser.getPhone());
		user.setSignature(myuser.getSignature());
		user.setRole(myuser.getRole());
		user.setIntroductionTitle(myuser.getIntroductionTitle());
		user.setSignatureTitle(myuser.getSignatureTitle());
		if(myuser.getIntroduction()==null) {
			user.setIntroduction(new ArrayList());
		}else {
			user.setIntroduction(myuser.getIntroduction());
		}
		return user;
	}
	@RequestMapping(value="/addContact", method = RequestMethod.POST,produces="application/json;charset=utf-8;")
	 @ResponseBody
	public String addContact(@RequestBody  MyContract myContract) {
		logger.info(" userId"+myContract.getUserId());
		logger.info(" contractId"+myContract.getContractId());
		logger.info("type"+myContract.getType());
		if(myContract.getType()==1) {
			wxUserServiceImp.changeCompany(myContract.getUserId(), myContract.getContractId());
			
		}else {
			
			
			try {
				wxUserServiceImp.addContact(myContract.getUserId(), myContract.getContractId());
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				wxUserServiceImp.addContact(myContract.getContractId(),myContract.getUserId());
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return "Success";
	}
	
	/**
	 * 显示社交信息
	 */
	@RequestMapping("/gam")
	public GamResult getgam(@RequestBody GamVo gamVo) {
		logger.info("gam id="+gamVo.getOwnerId());
		logger.info("gam id="+gamVo.getUserId());
		return wxUserServiceImp.getgam(gamVo);
	}
	
	/**
	 * 保存点赞
	 */
	@RequestMapping("/save/upvote")
	public String upvote(@RequestBody GamVo gamVo) {
		logger.info("upvote id="+gamVo.getOwnerId());
		wxUserServiceImp.upvote(gamVo);
		return "Success";
	}
	
	/**
	 * 保存浏览
	 */
	@RequestMapping("/save/skim")
	public String skim(@RequestBody GamVo gamVo) {
		logger.info("skim id="+gamVo.getOwnerId());
		wxUserServiceImp.skim(gamVo);
		return "Success";
	}
	/**
	 * 保存浏览
	 */
	@RequestMapping("/save/skim/{productId}")
	public String skim(@RequestBody GamVo gamVo,@PathVariable("productId") Integer productId) {
		logger.info("skim id="+gamVo.getOwnerId());
		gamVo.setProductId(productId);
		wxUserServiceImp.skim(gamVo);
		return "Success";
	}
	/**
	 * 保存转发
	 */
	@RequestMapping("/save/share")
	public String share(@RequestBody MyShareVo myShareVo) {
		logger.info("share owner id="+myShareVo.getOwnerId());
		logger.info("share id="+myShareVo.getShareId());
		
		wxUserServiceImp.share(myShareVo);
		return "Success";
	}
	/**
	 * 保存点赞
	 */
	@RequestMapping("/census/upvote/{userId}/{page}")
	public List<GamInfo> getupvote(@PathVariable("userId") Integer userId,@PathVariable("page") Integer page) {
		logger.info("/census/upvote userId="+userId+" page="+page);
		return wxUserServiceImp.getUpvote(userId,page);
		
	}
	
	/**
	 * 保存浏览
	 */
	@RequestMapping("/census/skim/{userId}/{page}")
	public  List<GamInfo> getskim(@PathVariable("userId") Integer userId,@PathVariable("page") Integer page) {
		logger.info("/census/skim userId="+userId+" page="+page);
		return wxUserServiceImp.getSkim(userId,page);
		
	}
	/**
	 * 获取转发
	 */
	@RequestMapping("/census/share/{userId}/{page}")
	public  List<GamInfo> getshare(@PathVariable("userId") Integer userId,@PathVariable("page") Integer page) {
		logger.info("/census/share userId="+userId+" page="+page);
		return wxUserServiceImp.getShare(userId,page);
		
	}
	@RequestMapping("/admin/{userId}")
	public  String setAdmin(@PathVariable("userId") Integer userId) {
		logger.info("/admin userId="+userId);
		 wxUserServiceImp.setAdmin(userId);
		 return "Success";
	}
	@RequestMapping("/workmate/delete/{userId}")
	public  String deleteWorkmate(@PathVariable("userId") Integer userId) {
		logger.info("/workmate/delete userId="+userId);
		 wxUserServiceImp.deleteWorkmate(userId);
		 return "Success";
	}
	
	
	@RequestMapping("/message")
	public String message(HttpServletRequest request) {
		Enumeration pnu=request.getParameterNames(); 
		while(pnu.hasMoreElements()){  
			String paraName=(String)pnu.nextElement();  
			String value=request.getParameter(paraName);
			System.out.println(paraName+" "+value);
		}
		if(request.getParameter("echostr")!=null) {
			return request.getParameter("echostr");
		}
		return "success";
	}
	
	@RequestMapping("/getYesterdayCensus")
	public  SkimVisitVo getYesterdayCensus() {
		 String userId=SecurityContextHolder.getContext().getAuthentication().getName();
		 return  wxUserServiceImp.skimAnalysis(Integer.valueOf(userId));
		
	}
	
	@RequestMapping("/getCumulativeVisits")
	public  SkimDayNumVo getCumulativeVisits(@RequestBody VisitVo visitVo) {
		 String userId=SecurityContextHolder.getContext().getAuthentication().getName();
		try {
		SimpleDateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate=formatter.parse(visitVo.getStartDate());
		Date endDate=formatter.parse(visitVo.getEndDate());
			
			return  wxUserServiceImp.skimDayAnalysis(Integer.valueOf(userId),beginDate,endDate);
		
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
		
		
	}
	@RequestMapping("/getProductVisits")
	public  List<SkimProductVo> getProductVisits(@RequestBody VisitVo visitVo) {
		try {
			SimpleDateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd");
			Date beginDate=formatter.parse(visitVo.getStartDate());
			Date endDate=formatter.parse(visitVo.getEndDate());
			String userId=SecurityContextHolder.getContext().getAuthentication().getName();
			return  wxUserServiceImp.productAnalysis(Integer.valueOf(userId),beginDate,endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
}

