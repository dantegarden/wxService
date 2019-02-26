package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.WxMyuser;
import com.bjdvt.wx.model.WxMyuserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxMyuserMapper {
    int countByExample(WxMyuserExample example);

    int deleteByExample(WxMyuserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxMyuser record);

    int insertSelective(WxMyuser record);

    List<WxMyuser> selectByExample(WxMyuserExample example);

    WxMyuser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxMyuser record, @Param("example") WxMyuserExample example);

    int updateByExample(@Param("record") WxMyuser record, @Param("example") WxMyuserExample example);

    int updateByPrimaryKeySelective(WxMyuser record);

    int updateByPrimaryKey(WxMyuser record);
}