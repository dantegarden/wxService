package com.bjdvt.wx.mapper;

import com.bjdvt.wx.controller.vo.SkimProductVo;
import com.bjdvt.wx.model.MyShare;
import com.bjdvt.wx.model.MyShareExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface MyShareMapper {
    int countByExample(MyShareExample example);

    int deleteByExample(MyShareExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MyShare record);

    int insertSelective(MyShare record);

    List<MyShare> selectByExample(MyShareExample example);

    MyShare selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MyShare record, @Param("example") MyShareExample example);

    int updateByExample(@Param("record") MyShare record, @Param("example") MyShareExample example);

    int updateByPrimaryKeySelective(MyShare record);

    int updateByPrimaryKey(MyShare record);
    
   
}