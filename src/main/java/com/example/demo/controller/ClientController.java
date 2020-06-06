package com.example.demo.controller;

import com.example.demo.model.Cars;
import com.example.demo.model.VehicleOwner;
import com.example.demo.model.VehicleView;
import com.example.demo.service.ICarService;
import com.example.demo.service.IVehicleOwnerService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * author duhongchi
 * <p> 客户信息管理
 * Date 2020/4/27
 */
@Controller
@RequestMapping("/client")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ClientController {

    @Autowired
    private ICarService carService;
    @Autowired
    private UserService userService;
    @Autowired
    private IVehicleOwnerService vehicleOwnerService;

    /**
     * 获取车辆列表
     * @param model
     * @return
     */
    @RequestMapping("/carslist")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView getCarList(Model model){
        List<Cars> carsList = carService.getCarList();
        model.addAttribute("user",userService.getUser());
        model.addAttribute("carsList",carsList);
        return new ModelAndView("/client/cars");
    }

    /**
     * 添加
     * @param model
     * @param cars
     * @param flag
     * @return
     */
    @RequestMapping("/addcars")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView addCars(Model model, Cars cars, String flag){
        cars.setCreateTime(new Date());
        cars.setCreateBy(userService.getUser().getUsername());
        cars.setStatus(1);
        if (flag.equals("1")){
            model.addAttribute("user",userService.getUser());
            return new ModelAndView("/client/addCars");
        }else {
            carService.addCar(cars);
            return new ModelAndView("redirect:/client/carslist");
        }
    }

    /**
     * 详细
     * @param carId
     * @param model
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/carsdetailpage")
    public ModelAndView getCarsDetailById(Integer carId, Model model){
        model.addAttribute("user",userService.getUser());
        model.addAttribute("car",carService.findCarById(carId));
        return new ModelAndView("/client/carsDetail");
    }

    /**
     * 修改
     * @param model
     * @param cars
     * @param flag
     * @return
     */
    @RequestMapping("modificars")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView modifiCars(Model model, Cars cars, String flag){
        model.addAttribute("user",userService.getUser());
        cars.setUpdateTime(new Date());
        cars.setUpdateBy(userService.getUser().getUsername());
        if (flag.equals("1")){
            Cars cars1 = carService.findCarById(cars.getCarId());
            model.addAttribute("cars",cars1);
            return new ModelAndView("client/modifiCars");
        }else {
            carService.modifiCar(cars);
            return new ModelAndView("redirect:/client/carslist");
        }
    }

    /**
     * 删除
     * @param model
     * @param carId
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/deletecars")
    public ModelAndView removeCars(Model model, Integer carId){
        model.addAttribute("user",userService.getUser());
        Cars cars = carService.findCarById(carId);
        cars.setStatus(0);
        carService.modifiCar(cars);
        return new ModelAndView("/client/cars");
    }

    /**
     * 获取列表
     * @param model
     * @return
     */
    @RequestMapping("/vehiclelist")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView getVehicleOwner(Model model){
        List<VehicleView> vehicleViewList = vehicleOwnerService.getVehicleOwnerList();
        model.addAttribute("user",userService.getUser());
        model.addAttribute("vehicleViewList",vehicleViewList);
        return new ModelAndView("/client/vehicleOwner");
    }

    /**
     * 详细
     * @param model
     * @param vehicleId
     * @return
     */
    @RequestMapping("/vehicledetail")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView getVehicleOwnerDetailPage(Model model, Integer vehicleId){
        model.addAttribute("user",userService.getUser());
        VehicleView vehicleView = vehicleOwnerService.findVehicleOwnerById(vehicleId);
        model.addAttribute("vehicleView",vehicleView);
        return new ModelAndView("/client/vehicleOwnerDetail");
    }

    /**
     * 添加
     * @param model
     * @param vehicleOwner
     * @param flag
     * @return
     */
    @RequestMapping("/addvehicle")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView addVehicleOwner(Model model, VehicleOwner vehicleOwner, String flag){
        List<Cars> carList = carService.getCarList();
        model.addAttribute("carList",carList);
        model.addAttribute("user",userService.getUser());
        vehicleOwner.setStatus(1);
        vehicleOwner.setCreateTime(new Date());
        vehicleOwner.setCreateBy(userService.getUser().getUsername());
        if (flag.equals("1")){
            return new ModelAndView("/client/addVehicleOwner");
        }else {
//            model.addAttribute("vehicleOwner",vehicleOwner);
            vehicleOwnerService.addVehicleOwner(vehicleOwner);
            return new ModelAndView("redirect:/client/vehiclelist");
        }
    }

    /**
     * 修改
     * @param model
     * @param flag
     * @param vehicleOwner
     * @return
     */
    @RequestMapping("/modifivehicle")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView modifiVehicleOwner(Model model, String flag, VehicleOwner vehicleOwner){
        List<Cars> carList = carService.getCarList();
        model.addAttribute("carList",carList);
        model.addAttribute("user",userService.getUser());
        vehicleOwner.setUpdateBy(userService.getUser().getUsername());
        vehicleOwner.setCreateTime(new Date());
        if (flag.equals("1")){
            VehicleView vehicleView = vehicleOwnerService.findVehicleOwnerById(vehicleOwner.getVehicleId());
            model.addAttribute("vehicleView",vehicleView);
            return new ModelAndView("/client/modifiVehicleOwner");
        }else {
            vehicleOwnerService.modifiVehicleOwner(vehicleOwner);
            return new ModelAndView("redirect:/client/vehiclelist");
        }
    }

    /**
     * 删除
     * @param model
     * @param vehicleId
     * @return
     */
    @RequestMapping("/deletevehicle")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView removeVehicleOwner(Model model, Integer vehicleId){
        VehicleView vehicleView = vehicleOwnerService.findVehicleOwnerById(vehicleId);
        vehicleView.setStatus(0);
        model.addAttribute("vehicleView",vehicleView);
        model.addAttribute("user",userService.getUser());
        return new ModelAndView("/client/vehicleOwner");

    }

}
