package com.example.demo.mapper;

import com.example.demo.model.VehicleView;
import com.example.demo.model.VehicleViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VehicleViewMapper {
    int countByExample(VehicleViewExample example);

    int deleteByExample(VehicleViewExample example);

    int insert(VehicleView record);

    int insertSelective(VehicleView record);

    List<VehicleView> selectByExample(VehicleViewExample example);

    int updateByExampleSelective(@Param("record") VehicleView record, @Param("example") VehicleViewExample example);

    int updateByExample(@Param("record") VehicleView record, @Param("example") VehicleViewExample example);
}