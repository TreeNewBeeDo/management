package com.example.demo.mapper;

import com.example.demo.model.ProductView;
import com.example.demo.model.ProductViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductViewMapper {
    int countByExample(ProductViewExample example);

    int deleteByExample(ProductViewExample example);

    int insert(ProductView record);

    int insertSelective(ProductView record);

    List<ProductView> selectByExample(ProductViewExample example);

    int updateByExampleSelective(@Param("record") ProductView record, @Param("example") ProductViewExample example);

    int updateByExample(@Param("record") ProductView record, @Param("example") ProductViewExample example);
}