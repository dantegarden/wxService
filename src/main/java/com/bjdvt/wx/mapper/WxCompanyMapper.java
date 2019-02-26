package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.WxCompany;
import com.bjdvt.wx.model.WxCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxCompanyMapper {
    int countByExample(WxCompanyExample example);

    int deleteByExample(WxCompanyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxCompany record);

    int insertSelective(WxCompany record);

    List<WxCompany> selectByExample(WxCompanyExample example);

    WxCompany selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxCompany record, @Param("example") WxCompanyExample example);

    int updateByExample(@Param("record") WxCompany record, @Param("example") WxCompanyExample example);

    int updateByPrimaryKeySelective(WxCompany record);

    int updateByPrimaryKey(WxCompany record);
}