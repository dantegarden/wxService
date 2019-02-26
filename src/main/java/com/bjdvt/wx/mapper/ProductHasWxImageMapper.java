package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.ProductHasWxImage;
import com.bjdvt.wx.model.ProductHasWxImageExample;
import com.bjdvt.wx.model.ProductHasWxImageKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductHasWxImageMapper {
    int countByExample(ProductHasWxImageExample example);

    int deleteByExample(ProductHasWxImageExample example);

    int deleteByPrimaryKey(ProductHasWxImageKey key);

    int insert(ProductHasWxImage record);

    int insertSelective(ProductHasWxImage record);

    List<ProductHasWxImage> selectByExample(ProductHasWxImageExample example);

    ProductHasWxImage selectByPrimaryKey(ProductHasWxImageKey key);

    int updateByExampleSelective(@Param("record") ProductHasWxImage record, @Param("example") ProductHasWxImageExample example);

    int updateByExample(@Param("record") ProductHasWxImage record, @Param("example") ProductHasWxImageExample example);

    int updateByPrimaryKeySelective(ProductHasWxImage record);

    int updateByPrimaryKey(ProductHasWxImage record);
}