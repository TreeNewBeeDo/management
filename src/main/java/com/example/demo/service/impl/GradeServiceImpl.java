package com.example.demo.service.impl;

import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.mapper.GradeMapper;
import com.example.demo.mapper.GradeViewMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Grade;
import com.example.demo.model.GradeExample;
import com.example.demo.model.GradeView;
import com.example.demo.model.GradeViewExample;
import com.example.demo.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author duhongchi
 * <p>
 * Date 2020/3/31
 */
@Service
public class GradeServiceImpl implements IGradeService {

    @Autowired
    private GradeViewMapper gradeViewMapper;

    @Autowired
    private GradeMapper gradeMapper;

    /**
     *
     * @return
     */
    @Override
    public List<GradeView> getGradeList() {
        GradeViewExample gradeViewExample = new GradeViewExample();
        GradeViewExample.Criteria criteria = gradeViewExample.createCriteria();
        List<GradeView> gradeViewList = gradeViewMapper.selectByExample(gradeViewExample);
        return gradeViewList;
    }

    /**
     *
     * @param gradeId
     * @return
     */
    @Override
    public GradeView findGradeById(Integer gradeId) {
        GradeViewExample gradeViewExample = new GradeViewExample();
        GradeViewExample.Criteria criteria = gradeViewExample.createCriteria();
        criteria.andGradeIdEqualTo(gradeId);
//        GradeExample.Criteria criteria = gradeExample.createCriteria();
//        criteria.andGradeIdEqualTo(gradeId);
        List<GradeView> gradeViewList = gradeViewMapper.selectByExample(gradeViewExample);
        if (gradeViewList.size() != 0){
            GradeView gradeView = gradeViewList.get(0);
            return gradeView;
        }else {
            return null;
        }

    }

//    @Override
//    public GradeView findGradeByEmployeeId(Integer employeeId) {
//        GradeViewExample gradeViewExample = new GradeViewExample();
//        GradeViewExample.Criteria criteria = gradeViewExample.createCriteria();
//        criteria.andEmployeeIdEqualTo(employeeId);
////        GradeExample.Criteria criteria = gradeExample.createCriteria();
////        criteria.andGradeIdEqualTo(gradeId);
//        List<GradeView> gradeViewList = gradeViewMapper.selectByExample(gradeViewExample);
//        if (gradeViewList.size() != 0){
//            GradeView gradeView = gradeViewList.get(0);
//            return gradeView;
//        }else {
//            return null;
//        }
//    }

    /**
     *
     * @param grade
     * @return
     */
    @Override
    public Grade addGrade(Grade grade) {
        GradeExample gradeExample = new GradeExample();
        gradeMapper.insertSelective(grade);
        return grade;
    }

    /**
     *
     * @param gradeId
     * @return
     */
    @Override
    public int removeGradeById(Integer gradeId) {
        GradeExample gradeExample =new GradeExample();
        return gradeMapper.deleteByPrimaryKey(gradeId);
    }

    /**
     *
     * @param grade
     */
    @Override
    public void modifiGrade(Grade grade) {
        GradeExample gradeExample =new GradeExample();
        gradeMapper.updateByPrimaryKeySelective(grade);
    }
}
