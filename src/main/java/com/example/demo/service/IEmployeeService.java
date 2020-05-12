package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * author duhongchi
 * <p> 员工管理服务层接口
 * Date 2020/3/26
 */
@Component
public interface IEmployeeService {
    /**
     * 获取员工列表
     * @return
     */
    List<Employee> getEmployeeList();

    /**
     * 通过员工id获取员工数据
     * @param employeeId
     * @return
     */
    Employee findByEmployeeId(Integer employeeId);

    /**
     * 增加员工
     * @param employee
     * @return
     */
    Employee addEmployee(Employee employee);

    /**
     * 删除员工
     * @param employeeId
     */
    public int removeEmployeeById(Integer employeeId);

    /**
     * 修改员工信息
     * @param employee
     */
    public void modifiEmployee(Employee employee);


    Employee getEmployeeView(Integer employeeId);



}
