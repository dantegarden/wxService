package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.PurchaseOrderReply;
import com.bjdvt.wx.model.PurchaseOrderReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseOrderReplyMapper {
    int countByExample(PurchaseOrderReplyExample example);

    int deleteByExample(PurchaseOrderReplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseOrderReply record);

    int insertSelective(PurchaseOrderReply record);

    List<PurchaseOrderReply> selectByExample(PurchaseOrderReplyExample example);

    PurchaseOrderReply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PurchaseOrderReply record, @Param("example") PurchaseOrderReplyExample example);

    int updateByExample(@Param("record") PurchaseOrderReply record, @Param("example") PurchaseOrderReplyExample example);

    int updateByPrimaryKeySelective(PurchaseOrderReply record);

    int updateByPrimaryKey(PurchaseOrderReply record);
}