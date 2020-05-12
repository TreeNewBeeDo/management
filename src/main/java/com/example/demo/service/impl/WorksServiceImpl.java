package com.example.demo.service.impl;

import com.example.demo.mapper.WorksMapper;
import com.example.demo.model.Works;
import com.example.demo.model.WorksExample;
import com.example.demo.service.IWorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author duhongchi
 * <p> 业务实现类
 * Date 2020/3/31
 */
@Service
public class WorksServiceImpl implements IWorksService {

    @Autowired
    private WorksMapper worksMapper;

    /**
     * 获取列表
     * @return
     */
    @Override
    public List<Works> getWorksList() {
        WorksExample worksExample = new WorksExample();
        WorksExample.Criteria criteria = worksExample.createCriteria();
        criteria.andStatusEqualTo(1);
        List<Works> worksList = worksMapper.selectByExample(worksExample);
        return worksList;
    }

    /**
     * 获取业务
     * @param workId
     * @return
     */
    @Override
    public Works findWorkById(Integer workId) {
        WorksExample worksExample = new WorksExample();
        Works works =worksMapper.selectByPrimaryKey(workId);
        return works;
    }

    /**
     * 添加
     * @param works
     * @return
     */
    @Override
    public Works addWork(Works works) {
        WorksExample worksExample = new WorksExample();
        worksMapper.insertSelective(works);
        return works;
    }

    /**
     * 修改
     * @param works
     */
    @Override
    public void modifiWork(Works works) {
        WorksExample worksExample = new WorksExample();
        worksMapper.updateByPrimaryKeySelective(works);

    }

    /**
     * 删除
     * @param workId
     * @return
     */
    @Override
    public int removeWork(Integer workId) {
        WorksExample worksExample = new WorksExample();
//        WorksExample.Criteria criteria = worksExample.createCriteria();
//        criteria.andWorkIdEqualTo(workId);
        return worksMapper.deleteByPrimaryKey(workId);

    }
}
