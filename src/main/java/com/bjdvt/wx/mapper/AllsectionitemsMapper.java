package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.Allsectionitems;
import com.bjdvt.wx.model.AllsectionitemsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AllsectionitemsMapper {
    int countByExample(AllsectionitemsExample example);

    int deleteByExample(AllsectionitemsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Allsectionitems record);

    int insertSelective(Allsectionitems record);

    List<Allsectionitems> selectByExample(AllsectionitemsExample example);

    Allsectionitems selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Allsectionitems record, @Param("example") AllsectionitemsExample example);

    int updateByExample(@Param("record") Allsectionitems record, @Param("example") AllsectionitemsExample example);

    int updateByPrimaryKeySelective(Allsectionitems record);

    int updateByPrimaryKey(Allsectionitems record);
}