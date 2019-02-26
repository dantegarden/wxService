package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.WxCompanyDescribe;
import com.bjdvt.wx.model.WxCompanyDescribeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxCompanyDescribeMapper {
    int countByExample(WxCompanyDescribeExample example);

    int deleteByExample(WxCompanyDescribeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxCompanyDescribe record);

    int insertSelective(WxCompanyDescribe record);

    List<WxCompanyDescribe> selectByExample(WxCompanyDescribeExample example);

    WxCompanyDescribe selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxCompanyDescribe record, @Param("example") WxCompanyDescribeExample example);

    int updateByExample(@Param("record") WxCompanyDescribe record, @Param("example") WxCompanyDescribeExample example);

    int updateByPrimaryKeySelective(WxCompanyDescribe record);

    int updateByPrimaryKey(WxCompanyDescribe record);
}