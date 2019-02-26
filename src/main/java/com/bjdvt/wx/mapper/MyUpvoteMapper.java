package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.MyUpvote;
import com.bjdvt.wx.model.MyUpvoteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyUpvoteMapper {
    int countByExample(MyUpvoteExample example);

    int deleteByExample(MyUpvoteExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MyUpvote record);

    int insertSelective(MyUpvote record);

    List<MyUpvote> selectByExample(MyUpvoteExample example);

    MyUpvote selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MyUpvote record, @Param("example") MyUpvoteExample example);

    int updateByExample(@Param("record") MyUpvote record, @Param("example") MyUpvoteExample example);

    int updateByPrimaryKeySelective(MyUpvote record);

    int updateByPrimaryKey(MyUpvote record);
}