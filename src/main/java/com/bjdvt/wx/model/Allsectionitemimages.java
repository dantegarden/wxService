package com.bjdvt.wx.model;

import java.io.Serializable;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-08-08
 */
public class Allsectionitemimages   implements Serializable{
    private Integer id;
    private static final long serialVersionUID = 1L;
    private Integer sectionItemId;

    private Integer imageId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSectionItemId() {
        return sectionItemId;
    }

    public void setSectionItemId(Integer sectionItemId) {
        this.sectionItemId = sectionItemId;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }
}