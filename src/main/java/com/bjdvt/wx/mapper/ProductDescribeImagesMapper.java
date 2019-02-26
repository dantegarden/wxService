package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.ProductDescribeImages;
import com.bjdvt.wx.model.ProductDescribeImagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductDescribeImagesMapper {
    int countByExample(ProductDescribeImagesExample example);

    int deleteByExample(ProductDescribeImagesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductDescribeImages record);

    int insertSelective(ProductDescribeImages record);

    List<ProductDescribeImages> selectByExample(ProductDescribeImagesExample example);

    ProductDescribeImages selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductDescribeImages record, @Param("example") ProductDescribeImagesExample example);

    int updateByExample(@Param("record") ProductDescribeImages record, @Param("example") ProductDescribeImagesExample example);

    int updateByPrimaryKeySelective(ProductDescribeImages record);

    int updateByPrimaryKey(ProductDescribeImages record);
}