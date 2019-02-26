package com.bjdvt.wx.mapper;

import com.bjdvt.wx.controller.vo.SkimDayNum;
import com.bjdvt.wx.controller.vo.SkimProductVo;
import com.bjdvt.wx.model.MySkim;
import com.bjdvt.wx.model.MySkimExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface MySkimMapper {
    int countByExample(MySkimExample example);

    int deleteByExample(MySkimExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MySkim record);

    int insertSelective(MySkim record);

    List<MySkim> selectByExample(MySkimExample example);

    MySkim selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MySkim record, @Param("example") MySkimExample example);

    int updateByExample(@Param("record") MySkim record, @Param("example") MySkimExample example);

    int updateByPrimaryKeySelective(MySkim record);

    int updateByPrimaryKey(MySkim record);
    @Select("SELECT P.ID, P.product_name, count(*) as num from my_skim s,product p where s.wx_user_id=#{userId} "
    		+ "and DATE_FORMAT(s.create_time, '%Y-%m-%d')>=  DATE_FORMAT(#{beginTime}, '%Y-%m-%d')"
    		+ "and DATE_FORMAT(s.create_time, '%Y-%m-%d')<=  DATE_FORMAT(#{endTime}, '%Y-%m-%d') "
    		+" and s.product_id=p.id"
    		+" group by P.ID, P.product_name")
    @Results({
        @Result(property = "productName",  column = "product_name", javaType = String.class),
        @Result(property = "productId", column = "id" , javaType = Integer.class),
        @Result(property = "count", column = "num" , javaType = Integer.class)
    })
    List<SkimProductVo> getSkimProduct(Integer userId,Date beginTime,Date endTime);
    
    
    

}