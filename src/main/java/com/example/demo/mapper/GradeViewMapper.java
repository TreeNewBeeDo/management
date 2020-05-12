package com.example.demo.mapper;

import com.example.demo.model.GradeView;
import com.example.demo.model.GradeViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradeViewMapper {
    int countByExample(GradeViewExample example);

    int deleteByExample(GradeViewExample example);

    int insert(GradeView record);

    int insertSelective(GradeView record);

    List<GradeView> selectByExample(GradeViewExample example);

    int updateByExampleSelective(@Param("record") GradeView record, @Param("example") GradeViewExample example);

    int updateByExample(@Param("record") GradeView record, @Param("example") GradeViewExample example);
}