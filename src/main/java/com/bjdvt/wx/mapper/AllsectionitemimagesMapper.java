package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.Allsectionitemimages;
import com.bjdvt.wx.model.AllsectionitemimagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AllsectionitemimagesMapper {
    int countByExample(AllsectionitemimagesExample example);

    int deleteByExample(AllsectionitemimagesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Allsectionitemimages record);

    int insertSelective(Allsectionitemimages record);

    List<Allsectionitemimages> selectByExample(AllsectionitemimagesExample example);

    Allsectionitemimages selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Allsectionitemimages record, @Param("example") AllsectionitemimagesExample example);

    int updateByExample(@Param("record") Allsectionitemimages record, @Param("example") AllsectionitemimagesExample example);

    int updateByPrimaryKeySelective(Allsectionitemimages record);

    int updateByPrimaryKey(Allsectionitemimages record);
}