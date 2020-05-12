package com.example.demo.service.impl;

import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeExample;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author duhongchi
 * <p>
 * Date 2020/3/31
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 获取列表
     * @return
     */
    @Override
    public List<Employee> getEmployeeList() {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andStatusEqualTo(1);
        List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);
        return employeeList;
    }

    /**
     * 获取
     * @param employeeId
     * @return
     */
    @Override
    public Employee findByEmployeeId(Integer employeeId) {
        EmployeeExample employeeExample = new EmployeeExample();
//        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
//        criteria.andEmployeeIdEqualTo(employeeId);
        Employee employee = employeeMapper.selectByPrimaryKey(employeeId);
        return employee;
    }


    /**
     * 添加
     * @param employee
     * @return
     */
    @Override
    public Employee addEmployee(Employee employee) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeMapper.insertSelective(employee);
        return employee;
    }

    /**
     * 删除
     * @param employeeId
     * @return
     */
    @Override
    public int removeEmployeeById(Integer employeeId) {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmployeeIdEqualTo(employeeId);
        return employeeMapper.deleteByExample(employeeExample);
    }

    @Override
    public void modifiEmployee(Employee employee) {
        EmployeeExample employeeExample = new EmployeeExample();
//        System.out.println("12312312312231");
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    @Override
    public Employee getEmployeeView(Integer employeeId) {

        return null;
    }
}
