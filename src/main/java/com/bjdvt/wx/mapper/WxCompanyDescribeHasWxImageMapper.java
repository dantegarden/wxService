package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.WxCompanyDescribeHasWxImage;
import com.bjdvt.wx.model.WxCompanyDescribeHasWxImageExample;
import com.bjdvt.wx.model.WxCompanyDescribeHasWxImageKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxCompanyDescribeHasWxImageMapper {
    int countByExample(WxCompanyDescribeHasWxImageExample example);

    int deleteByExample(WxCompanyDescribeHasWxImageExample example);

    int deleteByPrimaryKey(WxCompanyDescribeHasWxImageKey key);

    int insert(WxCompanyDescribeHasWxImage record);

    int insertSelective(WxCompanyDescribeHasWxImage record);

    List<WxCompanyDescribeHasWxImage> selectByExample(WxCompanyDescribeHasWxImageExample example);

    WxCompanyDescribeHasWxImage selectByPrimaryKey(WxCompanyDescribeHasWxImageKey key);

    int updateByExampleSelective(@Param("record") WxCompanyDescribeHasWxImage record, @Param("example") WxCompanyDescribeHasWxImageExample example);

    int updateByExample(@Param("record") WxCompanyDescribeHasWxImage record, @Param("example") WxCompanyDescribeHasWxImageExample example);

    int updateByPrimaryKeySelective(WxCompanyDescribeHasWxImage record);

    int updateByPrimaryKey(WxCompanyDescribeHasWxImage record);
}