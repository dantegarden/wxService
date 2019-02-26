package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.WxMessage;
import com.bjdvt.wx.model.WxMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxMessageMapper {
    int countByExample(WxMessageExample example);

    int deleteByExample(WxMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxMessage record);

    int insertSelective(WxMessage record);

    List<WxMessage> selectByExample(WxMessageExample example);

    WxMessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxMessage record, @Param("example") WxMessageExample example);

    int updateByExample(@Param("record") WxMessage record, @Param("example") WxMessageExample example);

    int updateByPrimaryKeySelective(WxMessage record);

    int updateByPrimaryKey(WxMessage record);
    
   
    int  selectCountByExample(WxMessageExample example);
}