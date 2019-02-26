package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.SaleOrderReplayLine;
import com.bjdvt.wx.model.SaleOrderReplayLineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SaleOrderReplayLineMapper {
    int countByExample(SaleOrderReplayLineExample example);

    int deleteByExample(SaleOrderReplayLineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SaleOrderReplayLine record);

    int insertSelective(SaleOrderReplayLine record);

    List<SaleOrderReplayLine> selectByExample(SaleOrderReplayLineExample example);

    SaleOrderReplayLine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SaleOrderReplayLine record, @Param("example") SaleOrderReplayLineExample example);

    int updateByExample(@Param("record") SaleOrderReplayLine record, @Param("example") SaleOrderReplayLineExample example);

    int updateByPrimaryKeySelective(SaleOrderReplayLine record);

    int updateByPrimaryKey(SaleOrderReplayLine record);
}