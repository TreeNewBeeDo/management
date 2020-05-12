package com.example.demo.mapper;

import com.example.demo.model.Works;
import com.example.demo.model.WorksExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorksMapper {
    int countByExample(WorksExample example);

    int deleteByExample(WorksExample example);

    int deleteByPrimaryKey(Integer workId);

    int insert(Works record);

    int insertSelective(Works record);

    List<Works> selectByExample(WorksExample example);

    Works selectByPrimaryKey(Integer workId);

    int updateByExampleSelective(@Param("record") Works record, @Param("example") WorksExample example);

    int updateByExample(@Param("record") Works record, @Param("example") WorksExample example);

    int updateByPrimaryKeySelective(Works record);

    int updateByPrimaryKey(Works record);
}