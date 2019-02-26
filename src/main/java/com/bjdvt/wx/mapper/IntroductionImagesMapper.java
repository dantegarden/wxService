package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.IntroductionImages;
import com.bjdvt.wx.model.IntroductionImagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IntroductionImagesMapper {
    int countByExample(IntroductionImagesExample example);

    int deleteByExample(IntroductionImagesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IntroductionImages record);

    int insertSelective(IntroductionImages record);

    List<IntroductionImages> selectByExample(IntroductionImagesExample example);

    IntroductionImages selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IntroductionImages record, @Param("example") IntroductionImagesExample example);

    int updateByExample(@Param("record") IntroductionImages record, @Param("example") IntroductionImagesExample example);

    int updateByPrimaryKeySelective(IntroductionImages record);

    int updateByPrimaryKey(IntroductionImages record);
}