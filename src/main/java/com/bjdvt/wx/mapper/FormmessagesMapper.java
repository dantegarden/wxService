package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.Formmessages;
import com.bjdvt.wx.model.FormmessagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FormmessagesMapper {
    int countByExample(FormmessagesExample example);

    int deleteByExample(FormmessagesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Formmessages record);

    int insertSelective(Formmessages record);

    List<Formmessages> selectByExample(FormmessagesExample example);

    Formmessages selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Formmessages record, @Param("example") FormmessagesExample example);

    int updateByExample(@Param("record") Formmessages record, @Param("example") FormmessagesExample example);

    int updateByPrimaryKeySelective(Formmessages record);

    int updateByPrimaryKey(Formmessages record);
}