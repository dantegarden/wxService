package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.WxUser;
import com.bjdvt.wx.model.WxUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxUserMapper {
    int countByExample(WxUserExample example);

    int deleteByExample(WxUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxUser record);

    int insertSelective(WxUser record);

    List<WxUser> selectByExample(WxUserExample example);

    WxUser selectByPrimaryKey(Integer id);
    WxUser selectByOpenId(String wxId);

    int updateByExampleSelective(@Param("record") WxUser record, @Param("example") WxUserExample example);

    int updateByExample(@Param("record") WxUser record, @Param("example") WxUserExample example);

    int updateByPrimaryKeySelective(WxUser record);

    int updateByPrimaryKey(WxUser record);
}