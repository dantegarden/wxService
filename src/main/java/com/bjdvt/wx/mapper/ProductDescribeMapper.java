package com.bjdvt.wx.mapper;

import com.bjdvt.wx.model.ProductDescribe;
import com.bjdvt.wx.model.ProductDescribeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductDescribeMapper {
    int countByExample(ProductDescribeExample example);

    int deleteByExample(ProductDescribeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductDescribe record);

    int insertSelective(ProductDescribe record);

    List<ProductDescribe> selectByExample(ProductDescribeExample example);

    ProductDescribe selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductDescribe record, @Param("example") ProductDescribeExample example);

    int updateByExample(@Param("record") ProductDescribe record, @Param("example") ProductDescribeExample example);

    int updateByPrimaryKeySelective(ProductDescribe record);

    int updateByPrimaryKey(ProductDescribe record);
}