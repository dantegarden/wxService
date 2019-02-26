package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.Allofficials;
import com.bjdvt.wx.model.AllofficialsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AllofficialsMapper {
    int countByExample(AllofficialsExample example);

    int deleteByExample(AllofficialsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Allofficials record);

    int insertSelective(Allofficials record);

    List<Allofficials> selectByExample(AllofficialsExample example);

    Allofficials selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Allofficials record, @Param("example") AllofficialsExample example);

    int updateByExample(@Param("record") Allofficials record, @Param("example") AllofficialsExample example);

    int updateByPrimaryKeySelective(Allofficials record);

    int updateByPrimaryKey(Allofficials record);
}