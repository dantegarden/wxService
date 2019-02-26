package com.bjdvt.wx.model;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-08-08
 */
public class Allsectionitems  implements Serializable {
    private Integer id;
    private static final long serialVersionUID = 1L;
    private String key;

    private Integer sectionId;

    private String text;

    private String title;

    private String subTitle;
    private  List<Allsectionitemimages> sectionImageList;
    
    
    
    public List<Allsectionitemimages> getSectionImageList() {
		return sectionImageList;
	}

	public void setSectionImageList(List<Allsectionitemimages> sectionImageList) {
		this.sectionImageList = sectionImageList;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

    public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }
}