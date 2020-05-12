package com.example.demo.service.impl;


import com.example.demo.mapper.CarsMapper;
import com.example.demo.model.Cars;
import com.example.demo.model.CarsExample;
import com.example.demo.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author duhongchi
 * <p>
 * Date 2020/3/31
 */
@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    private CarsMapper carsMapper;

    @Override
    public List<Cars> getCarList() {
        CarsExample carsExample = new CarsExample();
        CarsExample.Criteria criteria = carsExample.createCriteria();
        criteria.andStatusEqualTo(1);
        List<Cars> carsList = carsMapper.selectByExample(carsExample);
        return carsList;
    }

    @Override
    public Cars findCarById(Integer carId) {
        CarsExample carsExample = new CarsExample();
        Cars cars = carsMapper.selectByPrimaryKey(carId);
        return cars;
    }

    @Override
    public Cars addCar(Cars cars) {
        CarsExample carsExample = new CarsExample();
        carsMapper.insertSelective(cars);
        return cars;
    }

    @Override
    public void modifiCar(Cars cars) {
        CarsExample carsExample = new CarsExample();
        carsMapper.updateByPrimaryKeySelective(cars);

    }

    @Override
    public int removeCar(Integer carId) {
        CarsExample carsExample = new CarsExample();
        return carsMapper.deleteByPrimaryKey(carId);
    }
}
