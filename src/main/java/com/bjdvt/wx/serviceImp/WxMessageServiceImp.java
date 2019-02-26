package com.bjdvt.wx.serviceImp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.bjdvt.wx.controller.vo.FormMessageVo;
import com.bjdvt.wx.controller.vo.KeyWord;
import com.bjdvt.wx.controller.vo.TemplateData;
import com.bjdvt.wx.controller.vo.TemplateMessage;
import com.bjdvt.wx.controller.vo.TokenResult;
import com.bjdvt.wx.controller.vo.WxMessageResult;
import com.bjdvt.wx.mapper.FormmessagesMapper;
import com.bjdvt.wx.mapper.WxCompanyMapper;
import com.bjdvt.wx.mapper.WxMessageMapper;
import com.bjdvt.wx.mapper.WxUserMapper;
import com.bjdvt.wx.model.Formmessages;
import com.bjdvt.wx.model.FormmessagesExample;
import com.bjdvt.wx.model.MySkim;
import com.bjdvt.wx.model.MySkimExample;
import com.bjdvt.wx.model.MyUpvote;
import com.bjdvt.wx.model.WxCompany;
import com.bjdvt.wx.model.WxMessage;
import com.bjdvt.wx.model.WxMessageExample;
import com.bjdvt.wx.model.WxUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class WxMessageServiceImp {

	@Autowired
	private FormmessagesMapper formmessagesMapper;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private HttpServiceImp httpServiceImp;
	@Autowired
	private WxMessageMapper wxMessageMapper;
	@Autowired
	private WxUserMapper wxUserMapper;
	
	@Autowired
	private WxCompanyMapper wxCompanyMapper;
	
	Logger logger = LoggerFactory.getLogger(WxMessageServiceImp.class);
	
	public List<WxMessageResult> getAllMessage(Integer userId,Integer page) {
		PageHelper.startPage(page,10);
		WxMessageExample wxMessageExample=new WxMessageExample();
		wxMessageExample.createCriteria().andToUserIdEqualTo(userId);
		wxMessageExample.setOrderByClause("send_time desc ");
		List<WxMessage> wxMessageList=wxMessageMapper.selectByExample(wxMessageExample);
		PageInfo pageInfo = new PageInfo<>(wxMessageList,10);
		List<WxMessage> wxMessageList2=pageInfo.getList();
		List<WxMessageResult> wxMessageResultList=new ArrayList();
		for(WxMessage wxMessage:wxMessageList2) {
			WxMessageResult wxMessageResult=new WxMessageResult();
			wxMessageResult.setId(wxMessage.getId());
			wxMessageResult.setCompany(wxMessage.getCompany());
			wxMessageResult.setFromUserId(wxMessage.getFromUserId());
			wxMessageResult.setLoginName(wxMessage.getLoginName());
			wxMessageResult.setPhone(wxMessage.getPhone());
			wxMessageResult.setSendTime(wxMessage.getSendTime().getTime());
			wxMessageResult.setStatus(wxMessage.getStatus());
			wxMessageResult.setToUserId(wxMessage.getToUserId());
			wxMessageResult.setWords(wxMessage.getWords());
			WxUser user=wxUserMapper.selectByPrimaryKey(wxMessage.getFromUserId());
			if(user!=null) {

				wxMessageResult.setFromUserAvatar(user.getAvatar());
				wxMessageResult.setFromUserCompanyId(user.getWxCompanyId());
			}
			wxMessageResultList.add(wxMessageResult);
		}
		return wxMessageResultList;
	}
	public List<WxMessageResult> getMyMessage(Integer userId,Integer page) {
		PageHelper.startPage(page,10);
		WxMessageExample wxMessageExample=new WxMessageExample();
		wxMessageExample.createCriteria().andFromUserIdEqualTo(userId);
		wxMessageExample.setOrderByClause("send_time desc ");
		List<WxMessage> wxMessageList=wxMessageMapper.selectByExample(wxMessageExample);
		PageInfo pageInfo = new PageInfo<>(wxMessageList,10);
		List<WxMessage> wxMessageList2=pageInfo.getList();
		List<WxMessageResult> wxMessageResultList=new ArrayList();
		for(WxMessage wxMessage:wxMessageList2) {
			WxMessageResult wxMessageResult=new WxMessageResult();
			wxMessageResult.setId(wxMessage.getId());
			wxMessageResult.setCompany(wxMessage.getCompany());
			wxMessageResult.setFromUserId(wxMessage.getFromUserId());
			wxMessageResult.setLoginName(wxMessage.getLoginName());
			wxMessageResult.setPhone(wxMessage.getPhone());
			wxMessageResult.setSendTime(wxMessage.getSendTime().getTime());
			wxMessageResult.setStatus(wxMessage.getStatus());
			wxMessageResult.setToUserId(wxMessage.getToUserId());
			wxMessageResult.setWords(wxMessage.getWords());
			WxUser user=wxUserMapper.selectByPrimaryKey(wxMessage.getToUserId());
			if(user!=null) {

				wxMessageResult.setToUserAvatar(user.getAvatar());
				WxCompany wxCompany=wxCompanyMapper.selectByPrimaryKey(user.getWxCompanyId());
				if(wxCompany!=null) {
					wxMessageResult.setToUserCompany(wxCompany.getName());
				}
				wxMessageResult.setToUserCompanyId(user.getWxCompanyId());
				wxMessageResult.setToUserName(user.getName());
				wxMessageResult.setToUserPhone(user.getPhone());
			}
			wxMessageResultList.add(wxMessageResult);
		}
		return wxMessageResultList;
	}
	
	public WxMessageResult getMessage(Integer messageId) {
		WxMessage wxMessage=wxMessageMapper.selectByPrimaryKey(messageId);
		WxMessageResult wxMessageResult=new WxMessageResult();
		wxMessageResult.setId(wxMessage.getId());
		wxMessageResult.setCompany(wxMessage.getCompany());
		wxMessageResult.setFromUserId(wxMessage.getFromUserId());
		wxMessageResult.setLoginName(wxMessage.getLoginName());
		wxMessageResult.setPhone(wxMessage.getPhone());
		wxMessageResult.setSendTime(wxMessage.getSendTime().getTime());
		wxMessageResult.setStatus(wxMessage.getStatus());
		wxMessageResult.setToUserId(wxMessage.getToUserId());
		wxMessageResult.setWords(wxMessage.getWords());
		WxUser user=wxUserMapper.selectByPrimaryKey(wxMessage.getFromUserId());
		if(user!=null) {

			wxMessageResult.setFromUserAvatar(user.getAvatar());
			wxMessageResult.setFromUserCompanyId(user.getWxCompanyId());
		}
		WxUser touser=wxUserMapper.selectByPrimaryKey(wxMessage.getToUserId());
		if(touser!=null) {

			wxMessageResult.setToUserAvatar(touser.getAvatar());
			WxCompany wxCompany=wxCompanyMapper.selectByPrimaryKey(touser.getWxCompanyId());
			if(wxCompany!=null) {
				wxMessageResult.setToUserCompany(wxCompany.getName());
			}
			wxMessageResult.setToUserCompanyId(touser.getWxCompanyId());
			wxMessageResult.setToUserName(touser.getName());
			wxMessageResult.setToUserPhone(touser.getPhone());
		}
		return wxMessageResult;
		
	}
	
	/**
	 * 发送模版消息
	 * @param wxMessage
	 * @param formId
	 * @return
	 */
	public void sendTempletMessage(WxMessage wxMessage,String formId) {
		TokenResult tokenResult=tokenService.getToken("token");
		Date date=new Date();
		logger.info("timeout="+tokenResult.getTimeout());
		logger.info("date="+date);
		if(tokenResult.getTimeout()==null||date.after(tokenResult.getTimeout())) {
			tokenResult=tokenService.getNewToken("token");
		}
		String url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token="+tokenResult.getAccess_token();
		Map<String, Object> paramsMap = new HashMap();
		WxUser wxUser=wxUserMapper.selectByPrimaryKey(wxMessage.getToUserId());
//		paramsMap.put("touser", wxUser.getWxId());
//		paramsMap.put("template_id", "FvpXm0tPGYDd1v7vqN1lwRfvjVr10Pd0IMvZydoB0s8");
//		paramsMap.put("form_id", formId);
//		paramsMap.put("post", "/pages/message_view/view?id="+wxMessage.getId());
		TemplateMessage templateMessage=new TemplateMessage();
		templateMessage.setPage( "/pages/message_view/view?type=0&id="+wxMessage.getId());
		templateMessage.setTouser(wxUser.getWxId());
		templateMessage.setTemplate_id( "FvpXm0tPGYDd1v7vqN1lwRfvjVr10Pd0IMvZydoB0s8");
		templateMessage.setForm_id(formId);
		TemplateData data=new TemplateData();
		KeyWord keyword1=new KeyWord(); 
		keyword1.setValue(wxMessage.getLoginName());
		data.setKeyword1(keyword1);
		
		KeyWord keyword2=new KeyWord(); 
		keyword2.setValue(wxMessage.getPhone());
		data.setKeyword2(keyword2);
		
		KeyWord keyword3=new KeyWord(); 
		keyword3.setValue(wxMessage.getWords());
		data.setKeyword3(keyword3);
		
		KeyWord keyword4=new KeyWord(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		keyword4.setValue(sdf.format(wxMessage.getSendTime()));
		data.setKeyword4(keyword4);
		
		templateMessage.setData(data);
		
		logger.info(JSON.toJSONString(templateMessage));
		String strObject=JSON.toJSONString(templateMessage);
		//paramsMap.put("data", data);	
		
		String result=httpServiceImp.post(url, strObject);
		logger.info(result);
	}
	
	public Formmessages save(FormMessageVo formMessageVo) {
		Formmessages formmessages=new Formmessages();
		formmessages.setFormId(formMessageVo.getFormId());
		formmessages.setFromUserId(formMessageVo.getToUserId());
		formmessages.setCreateTime((int)(new Date().getTime()/1000));
		formmessages.setStatus(0);
		formmessagesMapper.insert(formmessages);
		return formmessages;
	}
	public WxMessage save(WxMessage wxMessage,String formId) {
		wxMessage.setSendTime(new Date());
		wxMessage.setStatus(0);
		wxMessageMapper.insert(wxMessage);
		Formmessages formmessages=new Formmessages();
		formmessages.setFormId(formId);
		formmessages.setMessageId(wxMessage.getId());
		formmessages.setFromUserId(wxMessage.getFromUserId());
		formmessages.setCreateTime((int)(new Date().getTime()/1000));
		formmessages.setStatus(0);
		formmessagesMapper.insert(formmessages);
		Formmessages formmessages2=getFormmessagesByStatus(0,wxMessage.getToUserId());
		if(formmessages2!=null) {
			sendTempletMessage(wxMessage,formmessages2.getFormId());
			formmessages2.setStatus(1);
			logger.info("update form");
			formmessagesMapper.updateByPrimaryKey(formmessages2);
		}
		return wxMessage;
	}
	
	private Formmessages getFormmessagesByStatus(Integer status,Integer userId) {
		FormmessagesExample formmessagesExample=new FormmessagesExample();
		long times=new Date().getTime();
		Integer t=(int)(times/1000)-604800;
		formmessagesExample.createCriteria().andStatusEqualTo(0).andFromUserIdEqualTo(userId)
		.andCreateTimeGreaterThanOrEqualTo(t);
		List<Formmessages> formmessagesExampleList=formmessagesMapper.selectByExample(formmessagesExample);
		if(formmessagesExampleList.size()>0) {
			return formmessagesExampleList.get(0);
		}
		return null;
	}
	public int getMessageStatus(Integer userId) {
		WxMessageExample wxMessageExample=new WxMessageExample();
		wxMessageExample.createCriteria()		
			.andToUserIdEqualTo(userId)
			.andStatusEqualTo(0);
		return wxMessageMapper.selectCountByExample(wxMessageExample);
		
	}
	public void readMessage(Integer messageId) {
		WxMessage wxMessage=wxMessageMapper.selectByPrimaryKey(messageId);
		wxMessage.setStatus(1);
		wxMessageMapper.updateByPrimaryKey(wxMessage);
	}
}
