package com.bjdvt.wx.mapper;

import com.bjdvt.wx.controller.vo.SkimDayNum;
import com.bjdvt.wx.model.Userskim;
import com.bjdvt.wx.model.UserskimExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserskimMapper {
    int countByExample(UserskimExample example);

    int deleteByExample(UserskimExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Userskim record);

    int insertSelective(Userskim record);

    List<Userskim> selectByExample(UserskimExample example);

    Userskim selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Userskim record, @Param("example") UserskimExample example);

    int updateByExample(@Param("record") Userskim record, @Param("example") UserskimExample example);

    int updateByPrimaryKeySelective(Userskim record);
    

    int updateByPrimaryKey(Userskim record);
    @Select("select DATE_FORMAT(create_date,'%m-%d') as day  ,s.flag as bz,count(*) as num from userskim s where owner_id=#{userId} "
    		+ " and DATE_FORMAT(s.create_date, '%Y-%m-%d')>=  DATE_FORMAT(#{beginTime}, '%Y-%m-%d')"
    		+ " and DATE_FORMAT(s.create_date, '%Y-%m-%d')<=  DATE_FORMAT(#{endTime}, '%Y-%m-%d') "
    		+ " group by DATE_FORMAT(create_date,'%m-%d'), flag")
    @Results({
        @Result(property = "day",  column = "day", javaType = String.class),
        @Result(property = "bz", column = "bz" , javaType = Integer.class),
        @Result(property = "count", column = "num" , javaType = Integer.class)
    })
    List<SkimDayNum> getSkimDayNum(Integer userId,Date beginTime,Date endTime);
}