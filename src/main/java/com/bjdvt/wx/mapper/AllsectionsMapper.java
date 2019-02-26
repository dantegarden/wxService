package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.Allsections;
import com.bjdvt.wx.model.AllsectionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AllsectionsMapper {
    int countByExample(AllsectionsExample example);

    int deleteByExample(AllsectionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Allsections record);

    int insertSelective(Allsections record);

    List<Allsections> selectByExample(AllsectionsExample example);

    Allsections selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Allsections record, @Param("example") AllsectionsExample example);

    int updateByExample(@Param("record") Allsections record, @Param("example") AllsectionsExample example);

    int updateByPrimaryKeySelective(Allsections record);

    int updateByPrimaryKey(Allsections record);
}