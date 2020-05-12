package com.example.demo.mapper;

import com.example.demo.model.Cars;
import com.example.demo.model.CarsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarsMapper {
    int countByExample(CarsExample example);

    int deleteByExample(CarsExample example);

    int deleteByPrimaryKey(Integer carId);

    int insert(Cars record);

    int insertSelective(Cars record);

    List<Cars> selectByExample(CarsExample example);

    Cars selectByPrimaryKey(Integer carId);

    int updateByExampleSelective(@Param("record") Cars record, @Param("example") CarsExample example);

    int updateByExample(@Param("record") Cars record, @Param("example") CarsExample example);

    int updateByPrimaryKeySelective(Cars record);

    int updateByPrimaryKey(Cars record);
}