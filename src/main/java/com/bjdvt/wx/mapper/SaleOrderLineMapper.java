package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.SaleOrderLine;
import com.bjdvt.wx.model.SaleOrderLineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SaleOrderLineMapper {
    int countByExample(SaleOrderLineExample example);

    int deleteByExample(SaleOrderLineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SaleOrderLine record);

    int insertSelective(SaleOrderLine record);

    List<SaleOrderLine> selectByExample(SaleOrderLineExample example);

    SaleOrderLine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SaleOrderLine record, @Param("example") SaleOrderLineExample example);

    int updateByExample(@Param("record") SaleOrderLine record, @Param("example") SaleOrderLineExample example);

    int updateByPrimaryKeySelective(SaleOrderLine record);

    int updateByPrimaryKey(SaleOrderLine record);
}