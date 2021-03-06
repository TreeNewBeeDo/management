package com.example.demo.service.impl;

import cn.hutool.core.date.DateUtil;
import com.example.demo.mapper.SalaryMapper;
import com.example.demo.model.Salary;
import com.example.demo.model.SalaryExample;
import com.example.demo.service.ISalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * author duhongchi
 * <p>
 * Date 2020/3/31
 */
@Service
public class SalaryServiceImpl implements ISalaryService {

    @Autowired
    private SalaryMapper salaryMapper;

    /**
     * 获取账单列表
     *
     * @return salaryList 所有账单
     * status为0：支出账单
     * status为1：收入账单
     */
    @Override
    public List<Salary> getSalary() {
        SalaryExample salaryExample = new SalaryExample();
        SalaryExample.Criteria criteria = salaryExample.createCriteria();
        criteria.andStatusIsNotNull();
        List<Salary> salaryList = salaryMapper.selectByExample(salaryExample);
        return salaryList;
    }

    /**
     * 获取总收入
     * @return
     */
    @Override
    public double getSalaryIncome() {
        double salaryIncome = 0;
        Date time1 = DateUtil.beginOfMonth(new Date());
        Date time2 = DateUtil.endOfMonth(new Date());
        SalaryExample salaryExample = new SalaryExample();
        SalaryExample.Criteria criteria = salaryExample.createCriteria();
        criteria.andStatusEqualTo(1);
        criteria.andUpdateTimeBetween(time1,time2);
        List<Salary> salaryList = salaryMapper.selectByExample(salaryExample);
        for (Salary salary : salaryList){
            salaryIncome += salary.getTotal();
        }
        return salaryIncome;
    }

    /**
     * 获取总支出
     * @return
     */
    @Override
    public double getSalaryPayOut() {
        double salaryPayout = 0;
        Date time1 = DateUtil.beginOfMonth(new Date());
        Date time2 = DateUtil.endOfMonth(new Date());
//        String time1 = DateUtil.beginOfMonth(new Date()).toStringDefaultTimeZone();
//        String time2 = DateUtil.endOfMonth(new Date()).toStringDefaultTimeZone();
        SalaryExample salaryExample = new SalaryExample();
        SalaryExample.Criteria criteria = salaryExample.createCriteria();
        criteria.andStatusEqualTo(0);
        criteria.andUpdateTimeBetween(time1,time2);
        List<Salary> salaryList = salaryMapper.selectByExample(salaryExample);
        if (salaryList.size()==0){
            System.out.println("列表为空");
        }else {
            for (Salary salary : salaryList){
                salaryPayout += salary.getTotal();
//                System.out.println(salary.getTotal());
            }
        }
//        System.out.println(salaryPayout);
        return salaryPayout;
    }

    /**
     * 根据状态值的不同获取不同账目类型的数量
     * @param status
     * @return
     */
    @Override
    public int getSalaryByStatus(Integer status) {
        SalaryExample salaryExample = new SalaryExample();
        SalaryExample.Criteria criteria = salaryExample.createCriteria();
        criteria.andStatusEqualTo(status);
        List<Salary> salaryList = salaryMapper.selectByExample(salaryExample);
        int counts = salaryList.size();
        return counts;
    }


    /**
     * 通过id查询
     * @param salaryId
     * @return
     */
    @Override
    public Salary findSalaryById(Integer salaryId) {
        SalaryExample salaryExample = new SalaryExample();
        Salary salary = salaryMapper.selectByPrimaryKey(salaryId);
        return salary;
    }

    /**
     *
     * @param salary
     */
    @Override
    public void addSalary(Salary salary) {
        SalaryExample salaryExample = new SalaryExample();
        salaryMapper.insertSelective(salary);
    }

    /**
     *
     * @param salaryId
     */
    @Override
    public void removeSalary(Integer salaryId) {
        SalaryExample salaryExample = new SalaryExample();
        Salary salary = salaryMapper.selectByPrimaryKey(salaryId);
        salary.setStatus(0);
        salaryMapper.updateByPrimaryKeySelective(salary);
    }

    /**
     *
     * @param salary
     */
    @Override
    public void modifiSalary(Salary salary) {
        SalaryExample salaryExample = new SalaryExample();
        salaryMapper.updateByPrimaryKeySelective(salary);
    }
}
