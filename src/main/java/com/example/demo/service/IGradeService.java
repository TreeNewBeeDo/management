package com.example.demo.service;

import com.example.demo.model.Grade;
import com.example.demo.model.GradeView;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * author duhongchi
 * <p> 员工评价接口类
 * Date 2020/3/26
 */
@Component
public interface IGradeService {
    /**
     * 获取员工评价列表
     * @return
     */
    List<GradeView> getGradeList();

    /**
     * 通过gradeid查看评价
     * @param gradeId
     * @return
     */
    public GradeView findGradeById(Integer gradeId);

//    /**
//     * 通姑员工id 查看对应的评价
//     * @param employeeId
//     * @return
//     */
//    public GradeView findGradeByEmployeeId(Integer employeeId);

    /**
     * 添加新评价
     * @param grade
     * @return
     */
    public Grade addGrade(Grade grade);

    /**
     * 删除评价
     * @param gradeId
     * @return
     */
    public int removeGradeById(Integer gradeId);

    /**
     * 修改评价
     * @param grade
     */
    public void modifiGrade(Grade grade);
}
