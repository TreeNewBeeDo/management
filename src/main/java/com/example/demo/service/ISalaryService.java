package com.example.demo.service;

import com.example.demo.model.Salary;

import java.util.List;

/**
 * author duhongchi
 * <p>
 * Date 2020/3/26
 */
public interface ISalaryService {
    /**
     * 获取账单列表
     * @return
     */
    public List<Salary> getSalary();

    /**
     * 获取本月总收入
     * @return
     */
    public double getSalaryIncome();

    /**
     * 获取本月总支出
     * @return
     */
    public double getSalaryPayOut();

    /**
     * 根据状态值获取对应类型的数量
     * @param status
     * @return
     */
    public int getSalaryByStatus(Integer status);

    /**
     * 通过id查询
     * @param salaryId
     * @return
     */
    public Salary findSalaryById(Integer salaryId);

    /**
     *
     * @param salary
     */
    public void addSalary(Salary salary);

    /**
     *
     * @param salaryId
     */
    public void removeSalary(Integer salaryId);

    /**
     *
     * @param salary
     */
    public void modifiSalary(Salary salary);
}
