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
public class Allofficials  implements Serializable {
    private Integer id;
    private static final long serialVersionUID = 1L;
    private Integer companyId;

    private String officialName;

    private Integer poster;

    private String officialDescribe;
    
    private List<Allsections> officialSections;
    

    public List<Allsections> getOfficialSections() {
		return officialSections;
	}

	public void setOfficialSections(List<Allsections> officialSections) {
		this.officialSections = officialSections;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName == null ? null : officialName.trim();
    }

    public Integer getPoster() {
        return poster;
    }

    public void setPoster(Integer poster) {
        this.poster = poster;
    }

    public String getOfficialDescribe() {
        return officialDescribe;
    }

    public void setOfficialDescribe(String officialDescribe) {
        this.officialDescribe = officialDescribe == null ? null : officialDescribe.trim();
    }
}