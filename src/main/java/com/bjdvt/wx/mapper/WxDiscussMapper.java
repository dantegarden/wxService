package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.WxDiscuss;
import com.bjdvt.wx.model.WxDiscussExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxDiscussMapper {
    int countByExample(WxDiscussExample example);

    int deleteByExample(WxDiscussExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxDiscuss record);

    int insertSelective(WxDiscuss record);

    List<WxDiscuss> selectByExample(WxDiscussExample example);

    WxDiscuss selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxDiscuss record, @Param("example") WxDiscussExample example);

    int updateByExample(@Param("record") WxDiscuss record, @Param("example") WxDiscussExample example);

    int updateByPrimaryKeySelective(WxDiscuss record);

    int updateByPrimaryKey(WxDiscuss record);
}