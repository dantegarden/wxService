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
public class Allsections  implements Serializable {
    private Integer id;
    private static final long serialVersionUID = 1L;
    private Integer officialId;

    private	String key;
    private Integer template;

    private String label;
    
    public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	private List<Allsectionitems>  sectionItems;
    
    

    public List<Allsectionitems> getSectionItems() {
		return sectionItems;
	}

	public void setSectionItems(List<Allsectionitems> sectionItems) {
		this.sectionItems = sectionItems;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOfficialId() {
        return officialId;
    }

    public void setOfficialId(Integer officialId) {
        this.officialId = officialId;
    }

    public Integer getTemplate() {
        return template;
    }

    public void setTemplate(Integer template) {
        this.template = template;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }
}