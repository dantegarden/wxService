package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.SaleOrderReply;
import com.bjdvt.wx.model.SaleOrderReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SaleOrderReplyMapper {
    int countByExample(SaleOrderReplyExample example);

    int deleteByExample(SaleOrderReplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SaleOrderReply record);

    int insertSelective(SaleOrderReply record);

    List<SaleOrderReply> selectByExample(SaleOrderReplyExample example);

    SaleOrderReply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SaleOrderReply record, @Param("example") SaleOrderReplyExample example);

    int updateByExample(@Param("record") SaleOrderReply record, @Param("example") SaleOrderReplyExample example);

    int updateByPrimaryKeySelective(SaleOrderReply record);

    int updateByPrimaryKey(SaleOrderReply record);
}