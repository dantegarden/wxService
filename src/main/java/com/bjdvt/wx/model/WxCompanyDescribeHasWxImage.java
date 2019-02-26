package com.bjdvt.wx.model;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-07-11
 */
public class WxCompanyDescribeHasWxImage extends WxCompanyDescribeHasWxImageKey {
    private Integer no;

    private byte[] describe;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public byte[] getDescribe() {
        return describe;
    }

    public void setDescribe(byte[] describe) {
        this.describe = describe;
    }
}