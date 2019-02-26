package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.PurchaseOrderReplayLine;
import com.bjdvt.wx.model.PurchaseOrderReplayLineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseOrderReplayLineMapper {
    int countByExample(PurchaseOrderReplayLineExample example);

    int deleteByExample(PurchaseOrderReplayLineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseOrderReplayLine record);

    int insertSelective(PurchaseOrderReplayLine record);

    List<PurchaseOrderReplayLine> selectByExample(PurchaseOrderReplayLineExample example);

    PurchaseOrderReplayLine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PurchaseOrderReplayLine record, @Param("example") PurchaseOrderReplayLineExample example);

    int updateByExample(@Param("record") PurchaseOrderReplayLine record, @Param("example") PurchaseOrderReplayLineExample example);

    int updateByPrimaryKeySelective(PurchaseOrderReplayLine record);

    int updateByPrimaryKey(PurchaseOrderReplayLine record);
}