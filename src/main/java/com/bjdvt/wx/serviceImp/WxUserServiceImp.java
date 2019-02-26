package com.bjdvt.wx.serviceImp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.bjdvt.wx.controller.UserController;
import com.bjdvt.wx.controller.vo.GamInfo;
import com.bjdvt.wx.controller.vo.GamResult;
import com.bjdvt.wx.controller.vo.GamVo;
import com.bjdvt.wx.controller.vo.MyShareVo;
import com.bjdvt.wx.controller.vo.Series;
import com.bjdvt.wx.controller.vo.SkimDayNum;
import com.bjdvt.wx.controller.vo.SkimDayNumVo;
import com.bjdvt.wx.controller.vo.SkimProductVo;
import com.bjdvt.wx.controller.vo.SkimVisitVo;
import com.bjdvt.wx.controller.vo.SkimVo;
import com.bjdvt.wx.controller.vo.Visits;
import com.bjdvt.wx.mapper.IntroductionImagesMapper;
import com.bjdvt.wx.mapper.MyShareMapper;
import com.bjdvt.wx.mapper.MySkimMapper;
import com.bjdvt.wx.mapper.MyUpvoteMapper;
import com.bjdvt.wx.mapper.UserskimMapper;
import com.bjdvt.wx.mapper.WxCompanyMapper;
import com.bjdvt.wx.mapper.WxMyuserMapper;
import com.bjdvt.wx.mapper.WxUserMapper;
import com.bjdvt.wx.model.IntroductionImages;
import com.bjdvt.wx.model.IntroductionImagesExample;
import com.bjdvt.wx.model.MyShare;
import com.bjdvt.wx.model.MyShareExample;
import com.bjdvt.wx.model.MySkim;
import com.bjdvt.wx.model.MySkimExample;
import com.bjdvt.wx.model.MyUpvote;
import com.bjdvt.wx.model.MyUpvoteExample;
import com.bjdvt.wx.model.Userskim;
import com.bjdvt.wx.model.UserskimExample;
import com.bjdvt.wx.model.WxCompany;
import com.bjdvt.wx.model.WxMyuser;
import com.bjdvt.wx.model.WxMyuserExample;
import com.bjdvt.wx.model.WxUser;
import com.bjdvt.wx.util.AesUtil;
import com.bjdvt.wx.util.Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class WxUserServiceImp {

	@Autowired
	private WxMyuserMapper wxMyuserMapper;
	
	@Autowired
	private WxUserMapper wxUserMapper;
	@Autowired
	private MyShareMapper myShareMapper;
	@Autowired
	private MySkimMapper mySkimMapper;
	@Autowired
	private MyUpvoteMapper myUpvoteMapper;
	@Autowired
	private UserskimMapper userskimMapper;
	@Autowired
	private WxMessageServiceImp wxMessageServiceImp;
	@Autowired
	private WxCompanyMapper wxCompanyMapper;
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Autowired
	private IntroductionImagesMapper introductionImagesMapper;
	Logger logger = LoggerFactory.getLogger(WxUserServiceImp.class);
	
	private	 final int pageSize=10;

	private  final java.text.DateFormat DateFormat = new java.text.SimpleDateFormat("yyyy/MM/dd hh:mm");
	
	
	public WxUser getWxUser(Integer userId) {
		WxUser wxuser=wxUserMapper.selectByPrimaryKey(userId);
		IntroductionImagesExample introductionImagesExample=new IntroductionImagesExample();
		introductionImagesExample.createCriteria().andWxUserIdEqualTo(userId);
		List<IntroductionImages> listIntroductionImages=introductionImagesMapper.selectByExample(introductionImagesExample);
		wxuser.setIntroduction(listIntroductionImages);
		return wxuser;
	}
	public void saveWxUser(WxUser wxUser) {
		
		IntroductionImagesExample introductionImagesExample=new IntroductionImagesExample();
		introductionImagesExample.createCriteria().andWxUserIdEqualTo(wxUser.getId());
		introductionImagesMapper.deleteByExample(introductionImagesExample);
		if(wxUser.getIntroduction()!=null) {
			for(IntroductionImages introductionImage:wxUser.getIntroduction()) {
				introductionImage.setWxUserId(wxUser.getId());
				introductionImagesMapper.insert(introductionImage);
			}
		}
		wxUserMapper.updateByPrimaryKey(wxUser);
	}
	/**
	 * 增加联系人
	 * @param userId
	 * @param contractId
	 */
	public void addContact(Integer userId, Integer contractId) {
		WxMyuser wxMyuser=new WxMyuser();
		wxMyuser.setType(1);
		wxMyuser.setMyUserId(userId);
		wxMyuser.setWxUserId(contractId);
		wxMyuserMapper.insert(wxMyuser);
		
		
	}
	/**
	 *   是否联系人
	 * @param userId
	 * @param contractId
	 */
	public boolean isContact(Integer userId, Integer contractId) {
		WxMyuserExample wxMyuserExample=new WxMyuserExample();
		wxMyuserExample.createCriteria().andWxUserIdEqualTo(userId)
		  .andWxUserIdEqualTo(contractId);
		int num=wxMyuserMapper.countByExample(wxMyuserExample);
		if(num>0) {
			return true;
		}
		return false;
		
		
	}
	
	
	/**
	 * 是否浏览过
	 * @param userId
	 * @return
	 */
	private boolean isSkimMe(Integer userId,Integer skimUserId) {
		UserskimExample userskimExample=new UserskimExample();
		userskimExample.createCriteria().andOwnerIdEqualTo(userId)
		.andWxUserIdEqualTo(skimUserId);
		List<Userskim> userskimList=userskimMapper.selectByExample(userskimExample);
		if(userskimList.size()>0) {
			return true;
		}else {
			return false;
		}
		
	}
	/**
	 * 添加浏览人数
	 * @param userId
	 * @return
	 */
	private void addSkimMe(Integer userId,Integer skimUserId,Integer flag) {
		UserskimExample userskimExample=new UserskimExample();
		userskimExample.createCriteria().andOwnerIdEqualTo(userId)
		.andWxUserIdEqualTo(skimUserId).andCreateDateEqualTo(new Date());
		List<Userskim> userskimList=userskimMapper.selectByExample(userskimExample);
		if(userskimList.size()>0) {
			Userskim userskim=userskimList.get(0);
			userskim.setNum(userskim.getNum()+1);
			userskim.setFlag(flag);
			userskimMapper.updateByPrimaryKey(userskim);
		}else {
			Userskim userskim=new Userskim();
			userskim.setOwnerId(userId);
			userskim.setWxUserId(skimUserId);
			userskim.setCreateDate(new Date());
			userskim.setNum(1);
			userskim.setFlag(flag);
			userskimMapper.insert(userskim);
			
		}
		
	}
	public WxUser get(Integer userId) {
		return wxUserMapper.selectByPrimaryKey(userId);
			
	}
	
	/**
	 * 修改个人所属的公司
	 * @param userId
	 * @param companyId
	 */
	public void changeCompany(Integer userId,Integer contractId) {
		WxUser wxContractUser=wxUserMapper.selectByPrimaryKey(contractId);
		WxUser wxUser=new WxUser();
		wxUser.setId(userId);
		wxUser.setRole(0);
		wxUser.setWxCompanyId(wxContractUser.getWxCompanyId());
		wxUserMapper.updateByPrimaryKeySelective(wxUser);
	}
	
	/**
	 * 显示社交信息
	 */
	public GamResult getgam( GamVo gamVo) {
		GamResult gamResult=new GamResult();
		gamResult.setNew(true);
		WxUser owner=wxUserMapper.selectByPrimaryKey(gamVo.getOwnerId());
		WxUser user= wxUserMapper.selectByPrimaryKey(gamVo.getUserId());
		if(owner.getWxCompanyId()!=null&&user.getWxCompanyId()!=null) {
			if(owner.getWxCompanyId().equals(user.getWxCompanyId())) {
				gamResult.setNew(false);
			}else {
				WxMyuserExample wxMyuserExample=new WxMyuserExample();
				wxMyuserExample.createCriteria().andMyUserIdEqualTo(gamVo.getOwnerId()).andWxUserIdEqualTo(gamVo.getUserId());
				List<WxMyuser> wxMyUserList=wxMyuserMapper.selectByExample(wxMyuserExample);
				if(wxMyUserList.size()>0) {
					gamResult.setNew(false);
				}
			}
			
		}
		MyUpvoteExample myUpvoteExample=new MyUpvoteExample();
		myUpvoteExample.createCriteria().andWxUserIdEqualTo(gamVo.getOwnerId()).andUpvoteUserIdEqualTo(gamVo.getUserId());
		List<MyUpvote> myupvoteList=myUpvoteMapper.selectByExample(myUpvoteExample);
		logger.info("upvote size="+myupvoteList.size());
		if(myupvoteList.size()>0) {
			gamResult.setUpvote(true);
		}else {
			gamResult.setUpvote(false);
		}
		

		MyUpvoteExample myUpvoteExample2=new MyUpvoteExample();
		myUpvoteExample2.createCriteria().andWxUserIdEqualTo(gamVo.getOwnerId());
		int upvoteNum=myUpvoteMapper.countByExample(myUpvoteExample2);
		gamResult.setUpvoteNum(upvoteNum);
		

		MyShareExample myShareExample=new MyShareExample();
		myShareExample.createCriteria().andOwnerIdEqualTo(gamVo.getOwnerId());
		int shareNum=myShareMapper.countByExample(myShareExample);
		gamResult.setShareNum(shareNum);
		

		MySkimExample mySkimExample=new MySkimExample();
		mySkimExample.createCriteria().andWxUserIdEqualTo(gamVo.getOwnerId());
		int skimNum=mySkimMapper.countByExample(mySkimExample);
		gamResult.setSkimNum(skimNum);
		
		int messageNum=wxMessageServiceImp.getMessageStatus(gamVo.getOwnerId());
		logger.info("messageNum="+messageNum);
		gamResult.setMessageNum(messageNum);
		
		return gamResult;
	}
	
	/**
	 * 保存点赞
	 */
	public void upvote( GamVo gamVo) {
		MyUpvoteExample myUpvoteExample=new MyUpvoteExample();
		myUpvoteExample.createCriteria().andWxUserIdEqualTo(gamVo.getOwnerId()).andUpvoteUserIdEqualTo(gamVo.getUserId());
		//myUpvoteExample.createCriteria().andUpvoteUserIdEqualTo(gamVo.getUserId());
		List<MyUpvote> myupvoteList=myUpvoteMapper.selectByExample(myUpvoteExample);
		if(myupvoteList.size()>0) {
			MyUpvote myUpvote=myupvoteList.get(0);
			myUpvoteMapper.deleteByPrimaryKey(myUpvote.getId());
		}
		else {
			MyUpvote myupvote=new MyUpvote();
			myupvote.setWxUserId(gamVo.getOwnerId());
			myupvote.setUpvoteUserId(gamVo.getUserId());
			myupvote.setCreateTime(new Date());
			myUpvoteMapper.insert(myupvote);
		
		}
		return ;
		
	}
	/**
	 * 保存浏览
	 */
	public void skim( GamVo gamVo) {
		
			MySkim mySkim=new MySkim();
			mySkim.setWxUserId(gamVo.getOwnerId());
			mySkim.setSkimUserId(gamVo.getUserId());
			mySkim.setCreateTime(new Date());
			mySkim.setProductId(gamVo.getProductId());
			mySkim.setLastShareId(gamVo.getLastShareId());
			Integer flag=0;
			if(!isSkimMe(gamVo.getOwnerId(),gamVo.getUserId())) {
				//addContact(gamVo.getOwnerId(),gamVo.getUserId());
				flag=0;
				mySkim.setFlag(flag);
			}else {
				flag=1;
				mySkim.setFlag(flag);
			}
			logger.info("flag=="+flag);
			addSkimMe(gamVo.getOwnerId(),gamVo.getUserId(),flag);
			mySkimMapper.insert(mySkim);
		
	}
	/**
	 * 保存浏览
	 */
	public void skim( GamVo gamVo,Integer productId) {
		
			MySkim mySkim=new MySkim();
			mySkim.setWxUserId(gamVo.getOwnerId());
			mySkim.setSkimUserId(gamVo.getUserId());
			mySkim.setCreateTime(new Date());
			mySkim.setProductId(productId);
			if(!isContact(gamVo.getOwnerId(),gamVo.getUserId())) {
				addContact(gamVo.getOwnerId(),gamVo.getUserId());
				mySkim.setFlag(0);
			}else {
				mySkim.setFlag(1);
			}
			mySkimMapper.insert(mySkim);
		
	}
	/**
	 * 保存分享
	 */
	public void share( MyShareVo myShareVo) {
		MyShare myShare=new MyShare();
		if(myShareVo.getAesGroup()!=null) {

			logger.info("share getEncryptedData="+myShareVo.getAesGroup().getEncryptedData());
			logger.info("share getSession_key="+myShareVo.getAesGroup().getSession_key());
			logger.info("share getIv="+myShareVo.getAesGroup().getIv());
			JSONObject groupObject=AesUtil.getGroupInfo(myShareVo.getAesGroup().getEncryptedData(), myShareVo.getAesGroup().getSession_key(), myShareVo.getAesGroup().getIv());
			String openGid=(String)groupObject.get("openGId");
			myShare.setGroupId(openGid);
		}
		
		myShare.setOwnerId(myShareVo.getOwnerId());
		myShare.setFromUserId(myShareVo.getFromUserId());
		myShare.setLastFormUserId(myShareVo.getLastFromUserId());
		myShare.setLastShareId(myShareVo.getLastShareId());
		myShare.setOwnerCompanyId(myShareVo.getOwnerCompanyId());
		myShare.setOwnerId(myShareVo.getOwnerId());
		myShare.setShareId(myShareVo.getShareId());
		myShare.setCreateTime(new Date());
		myShareMapper.insert(myShare);
		
	}
	
	
	/**
	 * 保存浏览
	 */
	public List<GamInfo> getSkim(Integer  userId,Integer page) {
		PageHelper.startPage(page,pageSize);
		MySkimExample mySkimExample=new MySkimExample();
		mySkimExample.createCriteria().andWxUserIdEqualTo(userId);
		mySkimExample.setOrderByClause("create_time desc ");
		List<MySkim> myskimList=mySkimMapper.selectByExample(mySkimExample);
		
		PageInfo pageInfo = new PageInfo<>(myskimList,pageSize);
		List<MySkim> myskimList2=pageInfo.getList();
		List<GamInfo> gamInfoList=new ArrayList();
		for(MySkim myskim:myskimList2) {
			GamInfo gamInfo=new GamInfo();
			gamInfo.setId(myskim.getId());
			gamInfo.setOwnerId(myskim.getWxUserId());
			gamInfo.setUserId(myskim.getSkimUserId());
			gamInfo.setCreateTime(DateFormat.format(myskim.getCreateTime()));
			WxUser wxUser=get(myskim.getSkimUserId());
			gamInfo.setUserName(wxUser.getName());
			gamInfo.setImageId(wxUser.getAvatar());
			gamInfoList.add(gamInfo);
		}
		return gamInfoList;
	}
	/**
	 * 保存转发
	 */
	public List<GamInfo> getUpvote( Integer  userId,Integer page) {
		
		PageHelper.startPage(page,pageSize);
		MyUpvoteExample myUpvoteExample=new MyUpvoteExample();
		myUpvoteExample.createCriteria().andWxUserIdEqualTo(userId);
		myUpvoteExample.setOrderByClause("create_time desc");
		List<MyUpvote> myupvoteList=myUpvoteMapper.selectByExample(myUpvoteExample);
		PageInfo pageInfo = new PageInfo<>(myupvoteList,pageSize);
		List<MyUpvote> myupvoteList2=pageInfo.getList();
		List<GamInfo> gamInfoList=new ArrayList();
		for(MyUpvote myUpvote:myupvoteList2) {
			GamInfo gamInfo=new GamInfo();
			gamInfo.setId(myUpvote.getId());
			gamInfo.setOwnerId(myUpvote.getWxUserId());
			gamInfo.setUserId(myUpvote.getUpvoteUserId());
			gamInfo.setCreateTime(DateFormat.format(myUpvote.getCreateTime()));
			WxUser wxUser=get(myUpvote.getUpvoteUserId());
			gamInfo.setUserName(wxUser.getName());
			gamInfo.setImageId(wxUser.getAvatar());
			gamInfoList.add(gamInfo);
		}
		return gamInfoList;
	}
	public List<GamInfo> getShare( Integer  userId,Integer page) {
		PageHelper.startPage(page,pageSize);
		MyShareExample myShareExample=new MyShareExample();
		myShareExample.createCriteria().andOwnerIdEqualTo(userId);
		myShareExample.setOrderByClause("create_time desc ");
		List<MyShare> myshareList=myShareMapper.selectByExample(myShareExample);
		PageInfo pageInfo = new PageInfo<>(myshareList,pageSize);
		List<MyShare> myshareList2=pageInfo.getList();
		List<GamInfo> gamInfoList=new ArrayList();
		for(MyShare myshare:myshareList2) {
			GamInfo gamInfo=new GamInfo();
			gamInfo.setId(myshare.getId());
			gamInfo.setOwnerId(myshare.getOwnerId());
			gamInfo.setUserId(myshare.getFromUserId());
			gamInfo.setCreateTime(DateFormat.format(myshare.getCreateTime()));
			WxUser wxUser=get(myshare.getFromUserId());
			gamInfo.setUserName(wxUser.getName());
			gamInfo.setImageId(wxUser.getAvatar());
			gamInfo.setGroupId(myshare.getGroupId());
			gamInfoList.add(gamInfo);
		}
		return gamInfoList;
		
	}
	/**
	 * 删除同事
	 * @param userId
	 */
	public void deleteWorkmate( Integer  userId) {
		WxUser wxUser=get(userId);
		WxCompany wxCompany=new WxCompany();
		wxCompany.setCreateTime(new Date());
		wxCompany.setName(wxUser.getName());
		wxCompany.setCompanyaddress(wxUser.getAddress());
		wxCompany.setCreateTime(new Date());
		wxCompanyMapper.insert(wxCompany);
		wxUser.setWxCompanyId(wxCompany.getId());
		wxUser.setRole(1);
		wxUserMapper.updateByPrimaryKey(wxUser);
		return ;
	}
	private int getSkimNum(Date beginDate,Date endDate,Integer userId,Integer flag) {
		UserskimExample userskimExample=new UserskimExample();
		if(flag!=null) {
			userskimExample.createCriteria().andCreateDateBetween(beginDate, endDate)
			.andFlagEqualTo(flag).andOwnerIdEqualTo(userId);
		}else {
			userskimExample.createCriteria().andCreateDateBetween(beginDate, endDate)
			.andOwnerIdEqualTo(userId);
		}
		System.out.println("beign="+beginDate+" end"+endDate);
		return userskimMapper.countByExample(userskimExample);
			
	}
	private int getShareNum(Date beginDate,Date endDate,Integer userId) {
		 MyShareExample myShareExample=new MyShareExample();
		 myShareExample.createCriteria().andOwnerIdEqualTo(userId)
		 .andCreateTimeBetween(beginDate, endDate);	 
		 return myShareMapper.countByExample(myShareExample);
			
	}
	public SkimVisitVo skimAnalysis(Integer userId) {
		SkimVo skimVo=new SkimVo();
		
		
		//新人
		Date beginDate=Util.getDayZero(new Date());
		Date endDate=new Date();
		int num=getSkimNum(beginDate,endDate,userId,0);
		skimVo.setSkimNewTodayNum(num);
		//周
		beginDate=Util.getThisWeekMonday(new Date());
		beginDate=Util.getDayZero(beginDate);
		endDate=new Date();
		skimVo.setSkimNewTswkNum(getSkimNum(beginDate,endDate,userId,0));
		//月 
		beginDate=Util.getThisMothOne(new Date());
	    beginDate=Util.getDayZero(beginDate);
		endDate=new Date();
		skimVo.setSkimNewMonthNum(getSkimNum(beginDate,endDate,userId,0));
		
		//旧人
		beginDate=Util.getDayZero(new Date());
		endDate=new Date();
		skimVo.setSkimTodayNum(getSkimNum(beginDate,endDate,userId,null));
		//周
		beginDate=Util.getThisWeekMonday(new Date());
		beginDate=Util.getDayZero(beginDate);
		endDate=new Date();
		skimVo.setSkimTswkNum(getSkimNum(beginDate,endDate,userId,null));
		//月 
		beginDate=Util.getThisMothOne(new Date());
		beginDate=Util.getDayZero(beginDate);
		endDate=new Date();
		skimVo.setSkimMonthNum(getSkimNum(beginDate,endDate,userId,null));
		
		
		//分享
		 beginDate=Util.getDayZero(new Date());
		 endDate=new Date();
		 skimVo.setShareTodayNum(getShareNum(beginDate,endDate,userId));
		
		 beginDate=Util.getThisWeekMonday(new Date());
		 beginDate=Util.getDayZero(beginDate);
		 endDate=new Date();
		 skimVo.setShareTswkNum(getShareNum(beginDate,endDate,userId));
		 
		 beginDate=Util.getThisMothOne(new Date());
		 beginDate=Util.getDayZero(beginDate);
		 endDate=new Date();
		 skimVo.setShareMonthNum(getShareNum(beginDate,endDate,userId));
		 
		 SkimVo upskimVo=new SkimVo();
		//同比数据
		//新人
			 beginDate=Util.getDayZero(new Date());
			 endDate=new Date();
			 beginDate=Util.getUpDay(beginDate, 1);
			 endDate=Util.getUpDay(endDate, 1);
			 num=getSkimNum(beginDate,endDate,userId,0);
			 upskimVo.setSkimNewTodayNum(num);
			//周
			beginDate=Util.getThisWeekMonday(new Date());
			beginDate=Util.getDayZero(beginDate);
			endDate=new Date();
			 beginDate=Util.getUpDay(beginDate, 7);
			 endDate=Util.getUpDay(endDate, 7);
			 upskimVo.setSkimNewTswkNum(getSkimNum(beginDate,endDate,userId,0));
			//月 
			
			 beginDate=Util.getUpMonthDay(new Date(), 1);
			 beginDate=Util.getThisMothOne(beginDate);
			 beginDate=Util.getDayZero(beginDate);
			endDate=new Date();
			 endDate=Util.getUpMonthDay(endDate, 1);
			 upskimVo.setSkimNewMonthNum(getSkimNum(beginDate,endDate,userId,0));
			
			//旧人
			beginDate=Util.getDayZero(new Date());
			beginDate=Util.getDayZero(beginDate);
			endDate=new Date();
			beginDate=Util.getUpDay(beginDate, 1);
			 endDate=Util.getUpDay(endDate, 1);
			 upskimVo.setSkimTodayNum(getSkimNum(beginDate,endDate,userId,null));
			//周
			beginDate=Util.getThisWeekMonday(new Date());
			beginDate=Util.getDayZero(beginDate);
			endDate=new Date();
			 beginDate=Util.getUpDay(beginDate, 7);
			 endDate=Util.getUpDay(endDate, 7);
			 upskimVo.setSkimTswkNum(getSkimNum(beginDate,endDate,userId,null));
			//月 
			 beginDate=Util.getUpMonthDay(new Date(), 1);
			 beginDate=Util.getThisMothOne(beginDate);
			 beginDate=Util.getDayZero(beginDate);
			endDate=new Date();
			 endDate=Util.getUpMonthDay(endDate, 1);
			 upskimVo.setSkimMonthNum(getSkimNum(beginDate,endDate,userId,null));
			
			
			//分享
			 beginDate=Util.getDayZero(new Date());
			 endDate=new Date();
			 beginDate=Util.getUpDay(beginDate, 1);
			 endDate=Util.getUpDay(endDate, 1);
			 upskimVo.setShareTodayNum(getShareNum(beginDate,endDate,userId));
			
			 beginDate=Util.getThisWeekMonday(new Date());
			 endDate=new Date();
			 beginDate=Util.getUpDay(beginDate, 7);
			 endDate=Util.getUpDay(endDate, 7);
			 upskimVo.setShareTswkNum(getShareNum(beginDate,endDate,userId));
			 
			 beginDate=Util.getThisMothOne(new Date());
			 endDate=new Date();
			 beginDate=Util.getUpMonthDay(beginDate, 1);
			 endDate=Util.getUpMonthDay(endDate, 1);
			 upskimVo.setShareMonthNum(getShareNum(beginDate,endDate,userId));
			 SkimVisitVo skimVisitVo=new SkimVisitVo();
			 Visits visits=new Visits();	
			 visits.setCount(skimVo.getSkimTodayNum());
			 if(upskimVo.getSkimTodayNum()>0) {
				 double day=(skimVo.getSkimTodayNum()-upskimVo.getSkimTodayNum())/(double)upskimVo.getSkimTodayNum();
				 visits.setDay((int)(day*100)+"%");
			 }else {
				 visits.setDay("100%");
			 }
			 if(upskimVo.getSkimTswkNum()>0) {
				 double week=(skimVo.getSkimTswkNum()-upskimVo.getSkimTswkNum())/(double)upskimVo.getSkimTswkNum();
				 visits.setWeek((int)(week*100)+"%");
			 }else {
				 visits.setWeek("100%"); 
			 }
			 if(upskimVo.getSkimMonthNum()>0) {
				 double month=(skimVo.getSkimMonthNum()-upskimVo.getSkimMonthNum())/(double)upskimVo.getSkimMonthNum();
				 visits.setMonth((int)(month*100)+"%");
			 }else {
				 visits.setMonth("100%"); 
			 }
			 skimVisitVo.setVisits(visits);
			 
			 Visits newVisits=new Visits();	
			 newVisits.setCount(skimVo.getSkimNewTodayNum());
			 if(upskimVo.getSkimNewTodayNum()>0) {
				 double day=(skimVo.getSkimNewTodayNum()-upskimVo.getSkimNewTodayNum())/(double)upskimVo.getSkimNewTodayNum();
				 newVisits.setDay((int)(day*100)+"%");
			 }else {
				 newVisits.setDay("100%"); 
			 }
			 if(upskimVo.getSkimNewTswkNum()>0) {
				 double week=(skimVo.getSkimNewTswkNum()-upskimVo.getSkimNewTswkNum())/(double)upskimVo.getSkimNewTswkNum();
				 newVisits.setWeek((int)(week*100)+"%");
			 }else {
				 newVisits.setWeek("100%"); 
			 }
			 if(upskimVo.getSkimNewMonthNum()>0) {
				 double month=(skimVo.getSkimNewMonthNum()-upskimVo.getSkimNewMonthNum())/(double)upskimVo.getSkimNewMonthNum();
				 newVisits.setMonth((int)(month*100)+"%");
			 }else {
				 newVisits.setMonth("100%"); 
			 }
			 skimVisitVo.setNewVisits(newVisits);
			 
			 Visits shareVisits=new Visits();
			 if(upskimVo.getShareTodayNum()>0) {
				 double day=(skimVo.getShareTodayNum()-upskimVo.getShareTodayNum())/(double)upskimVo.getShareTodayNum();
				 shareVisits.setDay((int)(day*100)+"%");
			 }else {
				 shareVisits.setDay("100%");
			 }
			 if(upskimVo.getShareTswkNum()>0) {
				 double week=(skimVo.getShareTswkNum()-upskimVo.getShareTswkNum())/(double)upskimVo.getShareTswkNum();
				 shareVisits.setWeek((int)(week*100)+"%");
			 }else {
				 shareVisits.setWeek("100%");
			 }
			 if(upskimVo.getShareMonthNum()>0) {
				 double month=(skimVo.getShareMonthNum()-upskimVo.getShareMonthNum())/(double)upskimVo.getShareMonthNum();
				 shareVisits.setMonth((int)(month*100)+"%");
			 }else {
				 shareVisits.setMonth("100%");
			 }
			 skimVisitVo.setShare(shareVisits);
		 return skimVisitVo;
	}
	
	public List<SkimProductVo> productAnalysis(Integer userId,Date beginDate ,Date endDate){
		List<SkimProductVo> skimProductVoList=mySkimMapper.getSkimProduct(userId, beginDate, endDate);
		System.out.println("skimProductVoList"+skimProductVoList.size());
		Double allCount=0.0;
		for(SkimProductVo skimProductVo:skimProductVoList) {
			allCount+=skimProductVo.getCount();
		}
		
		for(SkimProductVo skimProductVo:skimProductVoList) {
			if(allCount>0) {
				System.out.println("allCount="+allCount+" "+skimProductVo.getCount());
				skimProductVo.setPercent((int)(((double)skimProductVo.getCount()/allCount)*100));
			}
		}
		
		return skimProductVoList;
	}

	public SkimDayNumVo skimDayAnalysis(Integer userId,Date beginDate ,Date endDate)
	{
		List<SkimDayNum> skimDayNumList=userskimMapper.getSkimDayNum(userId, beginDate, endDate);
		System.out.println("skimDayNumList="+skimDayNumList.size());
		SkimDayNumVo skimDayNumVo=new SkimDayNumVo();
		if(endDate.before(beginDate))
			return null;
		List<Date> datesList=Util.getDatesBetweenTwoDate(beginDate,endDate);
		List<String> categoriesList=new ArrayList();
		skimDayNumVo.setCategories(categoriesList);
		List<Series> seriesList=new ArrayList();
		skimDayNumVo.setSeries(seriesList);
		Series series=new Series();
		seriesList.add(series);
		series.setTitle("访问量");
		List<Integer> dataList=new ArrayList();
		series.setData(dataList);
		
		
		
		
		Series newseries=new Series();
		seriesList.add(newseries);
		newseries.setTitle("新访问量");
		List<Integer> newdataList=new ArrayList();
		newseries.setData(newdataList);
		
		int total=0;
		for(Date date :datesList) {
			 SimpleDateFormat format = new SimpleDateFormat("MM-dd"); 
			 String day=format.format(date);
			 categoriesList.add(day);
			 boolean find=false;
			 boolean newfind=false;
			 int visitNum=0;
			 for(SkimDayNum skimDayNum:skimDayNumList) {
				 
				 if(skimDayNum.getDay().equals(day)) {
					 if(skimDayNum.getBz().equals(0)) {
						 newdataList.add(skimDayNum.getCount());
						 visitNum+=skimDayNum.getCount();
						 total+=skimDayNum.getCount();
						 newfind=true;
					 }
					 if(skimDayNum.getBz().equals(1)) {
						 //dataList.add(skimDayNum.getCount());
						 total+=skimDayNum.getCount();
						 visitNum+=skimDayNum.getCount();
						 find=true;
					 }
					 if(find==true&&newfind==true) {
						 break;
					 }
					 
				 }
			 }
			
			 dataList.add(visitNum);
			
			 if(newfind==false) {
				 newdataList.add(0);
			 }
			
			
		}
		skimDayNumVo.setTotal(total);
		return skimDayNumVo;
		
	}
	/**
	 * 设置管理员
	 * @param userId
	 */
	public void setAdmin( Integer  userId) {
		WxUser wxUser=get(userId);
		if(wxUser.getRole().equals(0)) {
			wxUser.setRole(1);
		}
		else {
			wxUser.setRole(0);
		}
		wxUserMapper.updateByPrimaryKey(wxUser);
		return ;
	}
	
}
