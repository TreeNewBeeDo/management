package com.example.demo.service;

import com.example.demo.model.VehicleOwner;
import com.example.demo.model.VehicleView;

import java.util.List;

/**
 * author duhongchi
 * <p> 客户信息操作接口类
 *
 * Date 2020/3/26
 */
public interface IVehicleOwnerService {
    /**
     * 获取客户列表
     * @return
     */
    public List<VehicleView> getVehicleOwnerList();

    /**
     * 添加新客户
     * @param vehicleOwner
     * @return
     */
    public VehicleOwner addVehicleOwner(VehicleOwner vehicleOwner);

    /**
     * 查询客户
     * @param vehicleId
     * @return
     */
    public VehicleView findVehicleOwnerById(Integer vehicleId);

    /**
     * 修改客户信息
     * @param vehicleOwner
     */
    public void modifiVehicleOwner(VehicleOwner vehicleOwner);

    /**
     * 删除客户信息
     * @param vehicleId
     * @return
     */
    public int removeVehicleOwnerById(Integer vehicleId);
}
