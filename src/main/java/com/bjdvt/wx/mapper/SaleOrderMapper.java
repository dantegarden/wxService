package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.SaleOrder;
import com.bjdvt.wx.model.SaleOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SaleOrderMapper {
    int countByExample(SaleOrderExample example);

    int deleteByExample(SaleOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SaleOrder record);

    int insertSelective(SaleOrder record);

    List<SaleOrder> selectByExample(SaleOrderExample example);

    SaleOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SaleOrder record, @Param("example") SaleOrderExample example);

    int updateByExample(@Param("record") SaleOrder record, @Param("example") SaleOrderExample example);

    int updateByPrimaryKeySelective(SaleOrder record);

    int updateByPrimaryKey(SaleOrder record);
}