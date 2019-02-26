package com.bjdvt.wx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.bjdvt.wx.controller.vo.AllOfficialVo;
import com.bjdvt.wx.model.Allofficials;
import com.bjdvt.wx.model.WxImage;
import com.bjdvt.wx.serviceImp.AllOfficialServiceImp;

@RestController
@RequestMapping(value = "/official",produces = "application/json;charset=UTF-8")
public class AllOfficialController {

	Logger logger = LoggerFactory.getLogger(AllOfficialController.class);
	@Autowired
	AllOfficialServiceImp allOfficialServiceImp;
	
	@RequestMapping(value="/save")
	@ResponseBody
	public Allofficials save(@RequestBody  AllOfficialVo allOfficialVo ){
		//logger.info("save Allofficials str="+str);
		// AllOfficialVo allOfficialVo =JSON.parseObject(str,AllOfficialVo.class);
		logger.info("save Allofficials companyid="+allOfficialVo.getCompanyId());
		allOfficialVo.getOfficial().setCompanyId(allOfficialVo.getCompanyId());
		return allOfficialServiceImp.saveOfficial(allOfficialVo.getOfficial());
		
	}

	@RequestMapping("/show/{companyId}")
	public Allofficials getAllofficials(@PathVariable("companyId")Integer  companyId) {
		return allOfficialServiceImp.getOfficial(companyId);
	}
		
}
