package com.bjdvt.wx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bjdvt.wx.controller.vo.AllOfficialVo;
import com.bjdvt.wx.controller.vo.FormMessageVo;
import com.bjdvt.wx.controller.vo.WxMessageResult;
import com.bjdvt.wx.controller.vo.WxMessageVo;
import com.bjdvt.wx.model.Allofficials;
import com.bjdvt.wx.model.WxMessage;
import com.bjdvt.wx.serviceImp.WxMessageServiceImp;

@RestController
@RequestMapping(value = "/user/message",produces = "application/json;charset=UTF-8")
public class MessageControll {
	@Autowired	
	private WxMessageServiceImp wxMessageServiceImp;
	@RequestMapping("/showAll/{userId}/{page}")
	public List<WxMessageResult> getAllofficials(@PathVariable("userId")Integer  userId,@PathVariable("page")Integer  page) {
		
		return wxMessageServiceImp.getAllMessage(userId, page);
	}
	
	@RequestMapping("/getMyMessage/{page}")
	public List<WxMessageResult> getMyMessage(@PathVariable("page")Integer  page) {
		
		String userId=SecurityContextHolder.getContext().getAuthentication().getName();
		return wxMessageServiceImp.getMyMessage(Integer.valueOf(userId), page);
	}
	
	
	@RequestMapping(value="/collect")
	@ResponseBody
	public String saveCollect(@RequestBody  FormMessageVo formMessageVo) {
		
		 wxMessageServiceImp.save(formMessageVo);
		return "success";
		
	}
	
	@RequestMapping(value="/save")
	@ResponseBody
	public WxMessage save(@RequestBody  WxMessageVo wxMessage) {
		
		return wxMessageServiceImp.save(wxMessage.getMessage(),wxMessage.getFormId());
		
	}
	
	
	@RequestMapping(value="/read/{id}")
	public String  readMessage(@PathVariable("id")Integer  messageId) {
		
		 wxMessageServiceImp.readMessage(messageId);
		 return "sucess";
		
	}
	
	@RequestMapping(value="/show/{id}")
	public WxMessageResult  show(@PathVariable("id")Integer  messageId) {
		
		return  wxMessageServiceImp.getMessage(messageId);
		
		
	}
	
}
