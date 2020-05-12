package com.example.demo.mapper;

import com.example.demo.model.Salary;
import com.example.demo.model.SalaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalaryMapper {
    int countByExample(SalaryExample example);

    int deleteByExample(SalaryExample example);

    int deleteByPrimaryKey(Integer salaryId);

    int insert(Salary record);

    int insertSelective(Salary record);

    List<Salary> selectByExample(SalaryExample example);

    Salary selectByPrimaryKey(Integer salaryId);

    int updateByExampleSelective(@Param("record") Salary record, @Param("example") SalaryExample example);

    int updateByExample(@Param("record") Salary record, @Param("example") SalaryExample example);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);
}