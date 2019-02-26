package com.bjdvt.wx.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bjdvt.wx.mapper.AllofficialsMapper;
import com.bjdvt.wx.mapper.AllsectionitemimagesMapper;
import com.bjdvt.wx.mapper.AllsectionitemsMapper;
import com.bjdvt.wx.mapper.AllsectionsMapper;
import com.bjdvt.wx.model.Allofficials;
import com.bjdvt.wx.model.AllofficialsExample;
import com.bjdvt.wx.model.Allsectionitemimages;
import com.bjdvt.wx.model.AllsectionitemimagesExample;
import com.bjdvt.wx.model.Allsectionitems;
import com.bjdvt.wx.model.Allsections;
import com.bjdvt.wx.model.AllsectionitemsExample;
import com.bjdvt.wx.model.AllsectionsExample;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class AllOfficialServiceImp {

	@Autowired
	private AllofficialsMapper allofficialsMapper;
	@Autowired
	private AllsectionitemimagesMapper allsectionitemimagesMapper;
	@Autowired
	private AllsectionitemsMapper allsectionitemsMapper;
	@Autowired
	private AllsectionsMapper allsectionsMapper;
	
	public Allofficials saveOfficial(Allofficials allofficials) {
		if(allofficials.getId()==null) {
			allofficialsMapper.insert(allofficials);
		}else {
			allofficialsMapper.updateByPrimaryKey(allofficials);
			Allofficials allofficialsold=getOfficial(allofficials.getCompanyId());
			
			for(Allsections allsections:allofficialsold.getOfficialSections()) {
				List<Allsectionitems> allsectionitemsList=getAllsectionitems(allsections.getId());
				allsections.setSectionItems(allsectionitemsList);
				for(Allsectionitems allsectionitems:allsectionitemsList) {
					deleteallsectionitemimages(allsectionitems.getId());
				}
				deleteAllsectionitems(allsections.getId());
				
			}
			deleteAllsections(allofficialsold.getId());
			
		}
		for(Allsections allsections:allofficials.getOfficialSections()) {
			allsections.setOfficialId(allofficials.getId());
			allsectionsMapper.insert(allsections);
			
			for(Allsectionitems allsectionitems:allsections.getSectionItems()) {
				allsectionitems.setSectionId(allsections.getId());
				allsectionitemsMapper.insert(allsectionitems);
				for(Allsectionitemimages allsectionitemimages:allsectionitems.getSectionImageList()) {
					allsectionitemimages.setSectionItemId(allsectionitems.getId());
					allsectionitemimagesMapper.insert(allsectionitemimages);
				}
				
			}
		}
		return allofficials;
		
	}
	/**
	 * 查找官网信息
	 * @param companyId
	 * @return
	 */
	public Allofficials  getOfficial(Integer companyId) {
		AllofficialsExample AllofficialsExample=new AllofficialsExample();
		AllofficialsExample.createCriteria().andCompanyIdEqualTo(companyId);
		List<Allofficials> allofficialsList=allofficialsMapper.selectByExample(AllofficialsExample);
		if(allofficialsList.size()==0) {
		   return new Allofficials();
		}
		Allofficials allofficials=allofficialsList.get(0);
		List<Allsections>  allsectionsList=getAllsections( allofficials.getId());
		allofficials.setOfficialSections(allsectionsList);
		for(Allsections allsections:allsectionsList) {
			allsections.setKey(allsections.getId().toString());
			List<Allsectionitems> allsectionitemsList=getAllsectionitems(allsections.getId());
			allsections.setSectionItems(allsectionitemsList);
			for(Allsectionitems allsectionitems:allsectionitemsList) {
				allsectionitems.setKey(allsectionitems.getId().toString());
				List<Allsectionitemimages>  allsectionitemimagesList=getallsectionitemimages(allsectionitems.getId());
				allsectionitems.setSectionImageList(allsectionitemimagesList);
			}
			
		}
		return allofficials;
		
		
		
	}
	private List<Allsections>  getAllsections(Integer allofficialsId){
		AllsectionsExample allsectionsExample=new AllsectionsExample();
		allsectionsExample.createCriteria().andOfficialIdEqualTo(allofficialsId);
		return allsectionsMapper.selectByExample(allsectionsExample);
	}
	private List<Allsectionitems> getAllsectionitems(Integer sectionId){
	
		AllsectionitemsExample allsectionitemsExample=new AllsectionitemsExample();
		allsectionitemsExample.createCriteria().andSectionIdEqualTo(sectionId);
		return allsectionitemsMapper.selectByExample(allsectionitemsExample);
	
	}
	private List<Allsectionitemimages> getallsectionitemimages(Integer allsectionitemsId ){
		AllsectionitemimagesExample allsectionitemimagesExample=new AllsectionitemimagesExample();
		allsectionitemimagesExample.createCriteria().andSectionItemIdEqualTo(allsectionitemsId);
		return allsectionitemimagesMapper.selectByExample(allsectionitemimagesExample);
	}
	
	private void  deleteAllsections(Integer allofficialsId){
		AllsectionsExample allsectionsExample=new AllsectionsExample();
		allsectionsExample.createCriteria().andOfficialIdEqualTo(allofficialsId);
		allsectionsMapper.deleteByExample(allsectionsExample);
	}
	private void deleteAllsectionitems(Integer sectionId){
	
		AllsectionitemsExample allsectionitemsExample=new AllsectionitemsExample();
		allsectionitemsExample.createCriteria().andSectionIdEqualTo(sectionId);
		allsectionitemsMapper.deleteByExample(allsectionitemsExample);
	
	}
	private void deleteallsectionitemimages(Integer allsectionitemsId ){
		AllsectionitemimagesExample allsectionitemimagesExample=new AllsectionitemimagesExample();
		allsectionitemimagesExample.createCriteria().andSectionItemIdEqualTo(allsectionitemsId);
		allsectionitemimagesMapper.deleteByExample(allsectionitemimagesExample);
	}
}
