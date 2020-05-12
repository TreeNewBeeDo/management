package com.example.demo.service.impl;

import com.example.demo.mapper.VehicleOwnerMapper;
import com.example.demo.mapper.VehicleViewMapper;
import com.example.demo.model.VehicleOwner;
import com.example.demo.model.VehicleOwnerExample;
import com.example.demo.model.VehicleView;
import com.example.demo.model.VehicleViewExample;
import com.example.demo.service.IVehicleOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author duhongchi
 * <p> 实现类
 * Date 2020/3/31
 */
@Service
public class VehicleOwnerServiceImpl implements IVehicleOwnerService {

    @Autowired
    private VehicleOwnerMapper vehicleOwnerMapper;

    @Autowired
    private VehicleViewMapper vehicleViewMapper;

    /**
     *
     * @return
     */
    @Override
    public List<VehicleView> getVehicleOwnerList() {
        VehicleViewExample vehicleViewExample = new VehicleViewExample();
        VehicleViewExample.Criteria criteria = vehicleViewExample.createCriteria();
        criteria.andStatusEqualTo(1);
        List<VehicleView> vehicleViewList = vehicleViewMapper.selectByExample(vehicleViewExample);
        return vehicleViewList;
    }

    /**
     *
     * @param vehicleOwner
     * @return
     */
    @Override
    public VehicleOwner addVehicleOwner(VehicleOwner vehicleOwner) {
        VehicleOwnerExample vehicleOwnerExample = new VehicleOwnerExample();
        vehicleOwnerMapper.insertSelective(vehicleOwner);
        return vehicleOwner;
    }

    /**
     *
     * @param vehicleId
     * @return
     */
    @Override
    public VehicleView findVehicleOwnerById(Integer vehicleId) {
        VehicleViewExample vehicleViewExample = new VehicleViewExample();
        VehicleViewExample.Criteria criteria = vehicleViewExample.createCriteria();
        criteria.andVehicleIdEqualTo(vehicleId);
        List<VehicleView> vehicleViewList = vehicleViewMapper.selectByExample(vehicleViewExample);
        if (vehicleViewList.size() != 0){
            VehicleView vehicleView = vehicleViewList.get(0);
            return vehicleView;
        }else {
            return null;
        }

    }

    /**
     *
     * @param vehicleOwner
     */
    @Override
    public void modifiVehicleOwner(VehicleOwner vehicleOwner) {
        VehicleOwnerExample vehicleOwnerExample = new VehicleOwnerExample();
        vehicleOwnerMapper.updateByPrimaryKeySelective(vehicleOwner);
    }

    /**
     *
     * @param vehicleId
     * @return
     */
    @Override
    public int removeVehicleOwnerById(Integer vehicleId) {
        VehicleOwnerExample vehicleOwnerExample = new VehicleOwnerExample();
        return vehicleOwnerMapper.deleteByPrimaryKey(vehicleId);
    }
}
