package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.PurchaseOrderLine;
import com.bjdvt.wx.model.PurchaseOrderLineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseOrderLineMapper {
    int countByExample(PurchaseOrderLineExample example);

    int deleteByExample(PurchaseOrderLineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseOrderLine record);

    int insertSelective(PurchaseOrderLine record);

    List<PurchaseOrderLine> selectByExample(PurchaseOrderLineExample example);

    PurchaseOrderLine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PurchaseOrderLine record, @Param("example") PurchaseOrderLineExample example);

    int updateByExample(@Param("record") PurchaseOrderLine record, @Param("example") PurchaseOrderLineExample example);

    int updateByPrimaryKeySelective(PurchaseOrderLine record);

    int updateByPrimaryKey(PurchaseOrderLine record);
}