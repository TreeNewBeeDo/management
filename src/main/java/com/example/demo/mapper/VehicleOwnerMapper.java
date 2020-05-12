package com.example.demo.mapper;

import com.example.demo.model.VehicleOwner;
import com.example.demo.model.VehicleOwnerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VehicleOwnerMapper {
    int countByExample(VehicleOwnerExample example);

    int deleteByExample(VehicleOwnerExample example);

    int deleteByPrimaryKey(Integer vehicleId);

    int insert(VehicleOwner record);

    int insertSelective(VehicleOwner record);

    List<VehicleOwner> selectByExample(VehicleOwnerExample example);

    VehicleOwner selectByPrimaryKey(Integer vehicleId);

    int updateByExampleSelective(@Param("record") VehicleOwner record, @Param("example") VehicleOwnerExample example);

    int updateByExample(@Param("record") VehicleOwner record, @Param("example") VehicleOwnerExample example);

    int updateByPrimaryKeySelective(VehicleOwner record);

    int updateByPrimaryKey(VehicleOwner record);
}