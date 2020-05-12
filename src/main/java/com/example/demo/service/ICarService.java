package com.example.demo.service;

import com.example.demo.model.Cars;

import java.util.List;

/**
 * author duhongchi
 * <p>
 * Date 2020/3/26
 */
public interface ICarService {
    /**
     *
     * @return
     */
    public List<Cars> getCarList();

    /**
     *
     * @param carId
     * @return
     */
    public Cars findCarById(Integer carId);

    /**
     *
     * @param cars
     * @return
     */
    public Cars addCar(Cars cars);

    /**
     *
     * @param cars
     */
    public void modifiCar(Cars cars);

    /**
     *
     * @param carId
     * @return
     */
    public int removeCar(Integer carId);
}
